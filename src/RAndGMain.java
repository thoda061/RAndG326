
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dathomson
 */
public class RAndGMain {
    
    private static int startInt = 0;
    private static int endInt = 0;
    
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            if(input.charAt(0) != '#') {
                int currChar = 0;
                for(int i = 0; i < input.length(); i++) {
                    if(input.charAt(i) == ' ') {
                        startInt = Integer.valueOf(input.substring(currChar, i));
                        currChar = i+1;
                        endInt = Integer.valueOf(input.substring(currChar));
                        i = input.length();
                    }
                }
                produceOutput();
            }
        }
    }
    
    public static void produceOutput() {
        StringBuilder sb = new StringBuilder();
        char[] numType = new char[startInt + endInt];
        numType[1] = 'G';
        for(int a = 2; a < startInt + endInt; a++) {
            ArrayList<Integer> nf = getNearFactors(a);
            int colorCount = 0;
            for(int i = 0; i < nf.size(); i++) {
                if(numType[nf.get(i)] == 'G') {
                    colorCount++;
                }
            }
            if(colorCount > nf.size()/2) {
                numType[a] = 'R';
            } else {
                numType[a] = 'G';
            }
        }
        for(int a = startInt; a < startInt + endInt; a++) {
            sb.append(numType[a]);
        }
        System.out.println(sb.toString());
    }
    
    public static ArrayList<Integer> getNearFactors(int n) {
        ArrayList<Integer> nf = new ArrayList();
        for(int i = 2; i <= n; i++) {
            if(!nf.contains(n/i)) {
                nf.add(n/i);
            }
        }
        return nf;
    }
    
}
