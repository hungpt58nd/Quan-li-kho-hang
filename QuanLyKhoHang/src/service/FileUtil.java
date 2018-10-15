/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Storm Spirit
 */
public class FileUtil {
    private BufferedWriter bw;
    private BufferedReader br;

    public FileUtil(String fileName) throws IOException {
        bw = new BufferedWriter(new FileWriter(new File(fileName)));
        br = new BufferedReader(new FileReader(new File(fileName)));
    }

    public List<String[]> readData() throws IOException {
        List<String[]> data = new ArrayList<>();

        String inLine = "";
        while ((inLine = br.readLine()) != null) {
            data.add(inLine.split("-"));
        }

        br.close();
        return data;
    }

    public void writeData(List<String> data) throws IOException {
        for(String inLine: data){
            bw.write(inLine + "\n");
        }
        bw.close();
    }


}
