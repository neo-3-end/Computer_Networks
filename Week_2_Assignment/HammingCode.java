import java.util.Scanner;

class math{
    public int power(int normal_num, int power_num){
	int n = normal_num;
        for(int i = 1; i <= (power_num - 1); i++){
            normal_num = normal_num * n;
        }
        return normal_num;
    }
    public int odd_or_even(int x){
        if(x%2 == 0)
            return 0;
        else
            return 1;
    }
}
public class HammingCode{
    public static void main(String args[]){
        math math = new math();
	    Scanner s = new Scanner(System.in);
	    int[] message = new int[7];
        for(int i = 0; i < 7; i++){
            message[i] = s.nextInt();
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
        for(int i = 0; i <= r; i++){
            int p;
            p = math.power(2, i);
            error_detection[p] = hamming_data[j];
            j++;
        }
        int k = 6;
        for(int i = 0; i < r; i++){
            if(error_detection[i] != -1){
                error_detection[i] = message[k];
                k = k - 1;
            }
        }
        int count_of_1 = 0;
        for(int i = 0; i < r; i = i + 2){
            if(error_detection[i] == 1)
                count_of_1 = count_of_1 + 1;           
        }
        int p1 = math.odd_or_even(count_of_1);
        count_of_1 = 0;
        for(int i = 0; i < r; i = i + 2){
            if(error_detection[i] == 1)
                count_of_1 = count_of_1 + 1;           
        }

    }
}