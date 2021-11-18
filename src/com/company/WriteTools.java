package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteTools {
    File write(String content,String path) throws IOException {
        File file=new File(path);
        OutputStream fos=new FileOutputStream(file);
        fos.write(content.getBytes());
        fos.close();
        return file;
    }
}
