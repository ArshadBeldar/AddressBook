package com.Igc.AddressBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
        try {

            String data = "Hi My Name is InfoGalaxy";
            Path filePath = Paths.get("D://Software//Sample.txt");
            byte[] bytedata = data.getBytes();
            Files.write(filePath, bytedata);

        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] arr = {12,67,34,89,32,55};
//        int sum=0;
//        for(int i=0;i<arr.length;i++) {
//            sum = sum + arr[i];
//        }
//        System.out.println("Sum="+sum);
        int a=89;
        Arrays.stream(arr).sorted().forEach(x-> System.out.println(x));
    }
}
