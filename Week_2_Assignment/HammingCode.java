import java.util.Scanner;

public class HammingCode{
    public static int power(int normal_num, int power_num){
        int n = normal_num;
            for(int i = 1; i <= (power_num - 1); i++){
                normal_num = normal_num * n;
            }
            return normal_num;
    }
    public static int odd_or_even(int[] x, int g){
        int count = 0;
        for(int i = 0; i < g; i++)
        {
            if(x[i] == 1)
                count = count + 1;
        }
        if(count%2 == 0)
            return 0;
        else
            return 1;
    }
    public static void main(String args[]){
	    Scanner s = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of bits of Hamming data: ");
        n = s.nextInt();
	    int[] message = new int[n];
        for(int i = 0; i < n; i++){
            message[i] = s.nextInt();
        }
        int[] reverse_of_message = new int[n];
        for(int i = 0; i < n; i++){
            reverse_of_message[i] = message[n - 1 - i];
        }
        int r = 1;
        while(power(2, r) < (n + r + 1)){
            r++;
        }
        int m = r + n;
        int[] error_detection = new int[r + n];
        for(int i = 0; i < m; i++){
            error_detection[i] = -1;
        }
        error_detection[0] = 0;
        error_detection[1] = 0;
        error_detection[3] = 0;
        int k = 0;
        for(int i = 0; i < m; i++){
            if(error_detection[i] == -1 && k < n){
                error_detection[i] = reverse_of_message[k];
                k = k + 1;
            }
        }
        if(n == 4){
            int[] p1 = new int[3];
            int[] p2 = new int[3];
            int[] p4 = new int[3];
            p1[0] = error_detection[2];
            p1[1] = error_detection[4];
            p1[2] = error_detection[6];
            p2[0] = error_detection[2];
            p2[1] = error_detection[5];
            p2[2] = error_detection[6];
            p4[0] = error_detection[4];
            p4[1] = error_detection[5];
            p4[2] = error_detection[6];
            error_detection[0] = odd_or_even(p1, 3);
            error_detection[1] = odd_or_even(p2, 3);
            error_detection[3] = odd_or_even(p4, 3);
        }
        else if(n == 3){
            int[] p1 = new int[2];
            int[] p2 = new int[2];
            int[] p4 = new int[2];
            p1[0] = error_detection[2];
            p1[1] = error_detection[4];
            p2[0] = error_detection[2];
            p2[1] = error_detection[5];
            p4[0] = error_detection[4];
            p4[1] = error_detection[5];
            error_detection[0] = odd_or_even(p1, 2);
            error_detection[1] = odd_or_even(p2, 2);
            error_detection[3] = odd_or_even(p4, 2);
        }
        for(int i = 0; i < m; i++ ){
            System.out.print(error_detection[i]);
        }
    }
}