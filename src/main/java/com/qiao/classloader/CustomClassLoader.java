package com.qiao.classloader;

import java.io.*;

public class CustomClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassFromFile(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String filename){
        byte[] classBuff = null;
        try(final InputStream is = getClass().getClassLoader().getResourceAsStream(filename.replace(".", File.separator) + ".class");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = is.read(buff)) != -1) {
                byteArrayOutputStream.write(buff, 0, len);
            }
            classBuff = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classBuff;
    }
}
