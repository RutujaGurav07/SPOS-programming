import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class asmpass2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedReader br1 = null;
        BufferedReader br2 = null;

        FileReader fr = null;
        FileReader fr1 = null;
        FileReader fr2 = null;

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            String ICfile = "D:/Rutuja/programming/java progam/spos practicle/OUTPUT/IC.txt";
            fr = new FileReader(ICfile);
            br = new BufferedReader(fr);

            String symtabfile = "D:/Rutuja/programming/java progam/spos practicle/OUTPUT/SYMTAB.txt";
            fr1 = new FileReader(symtabfile);
            br1 = new BufferedReader(fr1);

            String littabfile = "D:/Rutuja/programming/java progam/spos practicle/OUTPUT/LITTAB.txt";
            fr2 = new FileReader(littabfile);
            br2 = new BufferedReader(fr2);

            String objectcodefile = "D:/Rutuja/programming/java progam/spos practicle/OUTPUT/Ojectcode.txt";
            fw = new FileWriter(objectcodefile);
            bw = new BufferedWriter(fw);

            String line;
            while ((line = br.readLine()) != null) {

                String s1 = line.split("\t")[0];
                if (s1.equals("AD")) {
                    System.out.println("\n");
                    bw.write("\n");
                }

                if (s1.equals("IS") && line.split("\t").length > 2) {
                    int locCounter, index;
                    String data;
                    index = Integer.parseInt(line.split("\t")[4]);
                    if (line.split("\t")[3].equals("S")) {

                        data = Files
                                .readAllLines(
                                        Paths.get("D:/Rutuja/programming/java progam/spos practicle/OUTPUT/SYMTAB.txt"))
                                .get(index - 1);

                        locCounter = Integer.parseInt(data.split("\t")[1]);
                        System.out.println(line.split("\t")[1] + "\t" + line.split("\t")[2] + "\t" + locCounter);
                        bw.write(line.split("\t")[1] + "\t" + line.split("\t")[2] + "\t" + locCounter + "\n");
                    }
                    if (line.split("\t")[3].equals("L")) {

                        data = Files
                                .readAllLines(
                                        Paths.get("D:/Rutuja/programming/java progam/spos practicle/OUTPUT/LITTAB.txt"))
                                .get(index - 1);

                        locCounter = Integer.parseInt(data.split("\t")[1]);
                        System.out.println(line.split("\t")[1] + "\t" + line.split("\t")[2] + "\t" + locCounter);
                        bw.write(line.split("\t")[1] + "\t" + line.split("\t")[2] + "\t" + locCounter + "\n");

                    }

                }
                if (s1.equals("IS") && line.split("\t").length < 2) {
                    System.out.println("\n");
                    bw.write("\n");
                }
                if (s1.equals("DL")) {
                    System.out.println("00\t0\t" + line.split("\t")[3]);
                    bw.write("00\t0\t" + line.split("\t")[3] + "\n");
                }

            }
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
