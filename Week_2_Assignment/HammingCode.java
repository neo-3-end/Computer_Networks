import java.io.*;
import java.util.Scanner;
import java.math.*;

public class HammingCode{
    public static void main(String args[]){
	    Scanner s = new Scanner(System.in);
	    int[] message = new int[20];
        int n = 0;
        System.out.println("Enter the data in binary code: ");
        n = s.nextInt();
        for(int i = 0; i < n; i++){
            message[i] = s.nextInt();
        }
        int[] hamming_data = new int[20];
        System.out.println("Enter the number of bits for Hamming data: ");
        int m = s.nextInt();
        for(int i = 0; i < m; i++){
            hamming_data[i] = s.nextInt();
        }
        int r = Math.pow(2, r);
        if(r < m + n + 1){
            System.out.println("Error\n");
            
        }
        else{
            int[] Error_Detection = new int[20];
            for(int i = 0; i < m + n; i++){
                Error_Detection[i] = -1;
            }
        }
        int j = 0;
        for(int i = 1; i < m + n; i = i * 2){
            Error_Detection[i] = hamming_data[j];
            j++;
        }

    }
}