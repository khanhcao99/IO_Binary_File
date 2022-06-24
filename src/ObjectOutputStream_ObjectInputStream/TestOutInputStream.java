package ObjectOutputStream_ObjectInputStream;

import java.io.*;

public class TestOutInputStream {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\ASUS\\Desktop\\IO_Binary_File\\src\\ObjectOutputStream_ObjectInputStream\\test.txt");
        Product product = new Product(1, "Khánh", 22.3, "aloalo");
        Product product1 = new Product(13, "Kháwwnh", 22.3, "aloalo");
        try {
            writeFile(product1, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            readFile(product1, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(Product product, File file) throws IOException {
        try(ObjectOutputStream read = new ObjectOutputStream(new FileOutputStream(file))) {
            if (!file.exists()){
                file.createNewFile();
            }
            read.writeObject(product);
            read.flush();
        }catch (IOException e){
            System.err.println(e);
        }
        System.out.println("Succes");

    }

    public static void readFile(Product product, File file )throws IOException{
        ObjectInputStream obj = null;
        try {
           obj = new ObjectInputStream(new FileInputStream(file));
            Product product1 = (Product) obj.readObject();
            System.out.println(product1);
        }catch (IOException e){
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
