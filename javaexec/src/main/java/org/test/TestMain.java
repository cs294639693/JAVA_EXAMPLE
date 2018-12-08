package org.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestMain {

    public static void main(String[] args) {
        String[] cmd = {"C:\\Windows\\System32\\cmd.exe", "-c", "dir"};
        InputStream in = null;
        String result = null;
        try {
            Process pro = Runtime.getRuntime().exec(cmd);
            pro.waitFor();
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            while ((result = read.readLine()) != null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
