import java.util.*;
 
 public class Main {
 
     // This is a functional problem. You have to complete this function.
     // It takes as input a length and a 2D array of update operations.
     // It should return the modified array.
     public static int[] Range(int length, int[][] updates) {
         // write your code here. 
         int[] newarr = new int[length];

         for(int q =0; q<updates.length; q++){
            int st = updates[q][0];
            int en = updates[q][1];
            int inc = updates[q][2];

            newarr[st] = newarr[st] + inc;

            if(en + 1 < length){
                newarr[en + 1] = newarr[en + 1] - inc;

            }
                     
        }

        int sum = 0;
        for(int i=0;i<length;i++){
            sum += newarr[i];
            newarr[i] = sum;
        }
         

        return newarr;
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Input for length of first array.
         int length = sc.nextInt();
 
         int K = sc.nextInt();
 
         int[][] updates = new int[K][3];
 
         for (int i = 0; i < updates.length; i++) {
             for (int j = 0; j < updates[0].length; j++) {
                 updates[i][j] = sc.nextInt();
             }
         }
 
         int[] result = Range(length, updates);
         display(result);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 
 }
