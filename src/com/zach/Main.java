package com.zach;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter writer= new FileWriter("Part0.txt");
        BufferedWriter bufWriter =new BufferedWriter(writer);

        bufWriter.write("Name: Zach\n");
        bufWriter.write("Favorite color: Red\n");
        bufWriter.write("Class code: 2545\n");
        bufWriter.close();

        BufferedReader bufReader= new BufferedReader(new FileReader("Part0.txt"));
        String line=bufReader.readLine();
        while(line != null){
            System.out.println(line);
            line=bufReader.readLine();
        }bufReader.close();
    }
}
