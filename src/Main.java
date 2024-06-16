import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter("taming.out");

        int n = sc.nextInt();

        int[] cow = new int[n];

        for (int i = 0; i < n; i++) {
            cow[i] = sc.nextInt();
        }
        if (cow[0] > 0) { pw.println(-1); return;}
        cow[0] = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (cow[i] > 0) {
                count = 0;
                for (int j = i - cow[i]; j < i; j++) {
                    if (cow[j] != count && cow[j] >0) {
                        pw.println(-1);
                        pw.close();
                    }
                    cow[j] = count;
                    count++;
                }
            }
        }

        int breakout = 0;
        int uncert = 0;
        for (int i : cow) {
            if (i == 0) {
                breakout++;
            }
            else if (i==-1) {
                uncert++;
            }
        }
        pw.println(breakout + " " + (breakout+uncert));
        pw.close();
    }
}