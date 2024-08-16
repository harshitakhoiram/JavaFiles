// File: MyPack.java
import java.io.*;

// Define package mypack
class Concatenate {
    public void concat() throws IOException {
        System.out.println("Enter a string:");
        String1 ob = new String1();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ob.str1 = in.readLine();
        System.out.println("Enter another string:");
        ob.str2 = in.readLine();
        System.out.println("\nConcatenated string is: " + ob.str1.concat(ob.str2));
    }
}

class Extractstr {
    public void extract() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String1 ob = new String1();
        System.out.println("Enter a string:");
        ob.str1 = in.readLine();
        System.out.println("Enter starting and ending position:");
        ob.start = Integer.parseInt(in.readLine());
        ob.end = Integer.parseInt(in.readLine());
        System.out.println("Extracted string is: " + ob.str1.substring(ob.start, ob.end));
    }
}

class String1 {
    public String str1, str2;
    protected int start, end;
}

// Define package mypack1
public class DisplayString {
    public static void main(String[] args) throws IOException {
        Concatenate ob = new Concatenate();
        ob.concat();
        Extractstr ob1 = new Extractstr();
        ob1.extract();
    }
}
