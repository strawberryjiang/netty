package com.redwit.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: 测试bytebuffer
 * @author: yangjiang
 * @create: 2022-01-23 19:49
 **/
@Slf4j
public class TestByteBuffer {

    public static void main(String[] args) {
        //FileChannel
        //1、输入输出流 2、RandomAccessFile
        try {
            FileChannel channel = new FileInputStream("data.txt").getChannel();
            //准备缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(10);
            //从channel读取数据,向buffer写入
            for (; ; ) {
                int length = channel.read(buffer);
                if (-1 == length) {
                    break;
                }
                //打印buffer内容
                buffer.flip();//切换读模式
                while (buffer.hasRemaining()) {//是否还有数据
                    byte b = buffer.get();
                    log.debug("读取到的实际字节:{}",(char) b);
                }
                buffer.clear();;//切换到写模式
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
