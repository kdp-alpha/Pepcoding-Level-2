//tc = n log(log(n))


import java.util.*;

public class Main {
    
    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        // write your code here
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        int len = isPrime.length;

        for(int i=2;i*i<=len;i++){
            if(isPrime[i] == true){
                for(int j=2*i;j<len;j +=i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2;i<len;i++){
            if(isPrime[i] == true){
                System.out.print(i + " ");
            }
            
        }

    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static void main(String[] args) {   
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
