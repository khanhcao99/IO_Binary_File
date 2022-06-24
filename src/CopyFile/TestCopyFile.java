package CopyFile;

import java.io.*;

public class TestCopyFile {
    public static void main(String[] args) {
        File soure = new File("C:\\Users\\ASUS\\Desktop\\IO_Binary_File\\src\\CopyFile\\source.txt");
        File dest = new File("C:\\Users\\ASUS\\Desktop\\IO_Binary_File\\src\\CopyFile\\dest.txt");
        try {
            copyFile(soure, dest);
            System.out.println("Copy file succes");
        } catch (IOException e) {
            System.out.println("Cannot copy file");
        }


    }

    public static void copyFile(File source, File dest) throws IOException{
        try {
            InputStream sr = new FileInputStream(source);
            OutputStream dt = new FileOutputStream(dest);

            byte[] bytes = new byte[1024];
            int lenght;
            while ((lenght = sr.read(bytes)) > 0){
                dt.write(bytes, 0, lenght);
            }
            sr.close();
            dt.close();
        }catch(IOException e){
            System.err.println(e);
        }


    }
}
