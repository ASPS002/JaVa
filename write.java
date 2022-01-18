import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class wite {

  static class FastReader {

    // When a member is declared static, it can be accessed before any objects of its class are created,
    // and without reference to any object.
    // we are accessing static method m1() without creating any object of the Test class.
    // class Test
    // {
    //     // static method
    //     static void m1()
    //     {
    //         System.out.println("from m1");
    //     }

    //     public static void main(String[] args)
    //     {
    //           // calling m1 without creating
    //           // any object of class Test
    //            m1();
    //     }
    // }
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

  static class Edge {

    int to, dist;

    public Edge(int to, int dist) {
      this.to = to;
      this.dist = dist;
    }
  }

  static class Pair {

    int key;
    String value;

    public Pair(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  static FastReader fr = new FastReader();

  public static void main(String args[]) {
    int kk = 1;
    // kk = fr.nextInt();
    while (kk-- > 0) {
      solve();
    }
  }

  public static void solve() {
    PrintWriter out = new PrintWriter(System.out);
    TreeSet<Integer>tree=new TreeSet<Integer>();
    tree.add(4);
    tree.add(2);
    tree.add(9);
    tree.add(6);
    tree.add(-6);
    while(tree.size()>0)
    {
        out.println(tree.last());
        tree.remove(last);
    }
    // int n = fr.nextInt();

    // ArrayList<String> alst = new ArrayList<String>();
    // ArrayList<Pair> arr = new ArrayList<Pair>();
    // for (int i = 0; i < n; i++) {
    //   String s = fr.nextLine();
    //   int m = s.length();
    //   int num = 0;
    //   String t = "";
    //   for (int j = 0; j < m; j++) {
    //     if (s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9) {
    //       num = num * 10 + (s.charAt(j) - '0');
    //     } else {
    //       t += s.charAt(j);
    //     }
    //   }
    //   arr.add(new Pair(num, t));
    // }
    // Collections.sort(arr, (a, b) -> (a.key - b.key));
    // for (int i = 0; i < n; i++) {
    //   if (arr.get(i).key > i) {
    //     out.println(-1);
    //     out.close();
    //     return;
    //   }
    // }
    // int j = n;
    // for (int i = 0; i < n; i++) {
    //   alst.add( arr.get(i).value);
    // }
    
    // for (int i = 0; i < alst.size(); i++) {
    //   out.println(alst.get(i) + " " + j--);
    // }
    out.close();
    return;
  }
}
