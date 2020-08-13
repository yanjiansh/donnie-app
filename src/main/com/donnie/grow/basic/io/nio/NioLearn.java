package com.donnie.grow.basic.io.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioLearn {

    public static void main (String[] args) throws IOException {
        RandomAccessFile af = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel fc = af.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = fc.read(buf);
        while(bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = fc.read(buf);
        }
        af.close();

    }
}
