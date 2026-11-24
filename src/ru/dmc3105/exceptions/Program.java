package ru.dmc3105.exceptions;

import java.io.*;

public class Program {
    public static void main() {

        try (var fis = new FileInputStream("C:\\Users\\algov\\source\\local\\java\\firstproject\\src\\ru\\dmc3105\\exceptions\\data.txt"))
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = br.readLine()) != null){
                IO.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
