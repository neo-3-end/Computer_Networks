import java.util.Scanner;

public class HammingCode{
    public static int power(int normal_num, int power_num){
        int n = normal_num;
            for(int i = 1; i <= (power_num - 1); i++){
                normal_num = normal_num * n;
            }
            return normal_num;
        }
        public static int odd_or_even(int x){
            if(x%2 == 0)
                return 0;
            else
                return 1;
        }
    public static void main(String args[]){
	    Scanner s = new Scanner(System.in);
	    int[] message = new int[7];
        for(int i = 0; i < 7; i++){
            message[i] = s.nextInt();
        }
        int[] reverse_of_message = new int[7];
        for(int i = 6; i <= 0; i--){
            reverse_of_message[i] = message[6 - i];
        }
        int[] hamming_data = new int[4];
        for(int i = 0; i < 4; i++){
            hamming_data[i] = s.nextInt();
        }
        int r = 11;
        int[] error_detection = new int[20];
        for(int i = 0; i < r; i++){
            error_detection[i] = -1;
        }
        int j = 0;
        for(int i = 0; i < 4; i++){
            int p;
            p = power(2, i);
            error_detection[p] = hamming_data[j];
            j++;
        }
        int k = 6;
        for(int i = 0; i < r; i++){
            if(error_detection[i] == -1 && k >= 0){
                error_detection[i] = message[k];
                k = k - 1;
            }
        }
        int count_of_1 = 0;
        for(int i = 0; i < r; i = i + 2){
            if(error_detection[i] == 1)
                count_of_1 = count_of_1 + 1;           
        }
        int p1 = odd_or_even(count_of_1);
        count_of_1 = 0;
        for(int i = 0; i < r; i = i + 4){
            for(int u = i; u < (i + 2); u++){
                if(error_detection[u] == 1)
                    count_of_1 = count_of_1 + 1;
            }           
        }
        int p2 = odd_or_even(count_of_1);
        count_of_1 = 0;
        for(int i = 3; i < r; i = i + 8){
            for(int v = i; v < (i + 4); v++){
                if(error_detection[v] == 1)
                    count_of_1 = count_of_1 + 1;
            }
        }
        int p4 = odd_or_even(count_of_1);
        count_of_1 = 0;
        p1 = p1 * power(2, 0);
        p2 = p2 * power(2, 1);
        p4 = p4 * power(2, 2);
        int error_index = p1 + p2 + p4;
        if(error_detection[error_index] == 1)
            error_detection[error_index] = 0;
        else
            error_detection[error_index] = 1;
        for(int i = 0; i < 11; i++){
            System.out.print(error_detection[i]);
        }
    }
}