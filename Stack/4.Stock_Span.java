import java.util.*;
class Main
{
    public static class Pair {
    int first;
    int second;
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
 static Stack<Pair> st = new Stack<>();
   
  
 
  public static void printNGE(int arr[], int n)
  {
    int[] ans = new int[n];
    int k = 0;
   
    for (int i = 0; i < n; i++) {
      if (st.size() == 0) {
        ans[k++] = -1;
      }
      else if (st.size() > 0 && st.peek().first > arr[i]) {
        ans[k++] = st.peek().second;
      }
      else if (st.size() > 0 && st.peek().first < arr[i]) {
        while (st.size() > 0 && st.peek().first < arr[i]) {
          st.pop();
        }
        if (st.size() == 0) {
          ans[k++] = -1;
        }
        else {
          ans[k++] = st.peek().second;
        }

      }

      st.add(new Pair(arr[i],i));

    }

    for (int i = 0; i < ans.length; i++) {
      System.out.println(i-ans[i]);
    }
  }

  public static void main(String args[])
  {
    int arr[] = {100,80,60,70,60,75,85};
    int n = arr.length;
    printNGE(arr, n);

  }
}
