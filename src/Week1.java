import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pooja on 5/14/2014.
 */
public class Week1 {
  static long inversions = 0;
  public static void main(String args[]) throws IOException {
    List<Integer> k = new ArrayList<Integer>();
    BufferedReader reader;
    reader=new BufferedReader(new FileReader("C:\\Users\\pooja\\IdeaProjects\\untitled\\src\\IntegerArray.txt"));
//    String str[] = reader.readLine().split(",");
//    for (String s : str)  {
//      k.add(Integer.parseInt(s.trim()));
//    }
    for (int i = 1; i <= 100000; ++i) {
        k.add(Integer.parseInt(reader.readLine()));
    }
    reader.close();
    sort(k.subList(0, k.size()/2), k.subList(k.size()/2, k.size()));
    System.out.println(inversions);
  }

  public static List<Integer> sort(List<Integer> l1, List<Integer> l2) {
    // recurse if list has more than 1 element
    if (l1.size() > 1)  {
      int half = l1.size()/2;
      l1 = sort(l1.subList(0, half), l1.subList(half, l1.size()));
    }
    if (l2.size() > 1)  {
      int half = l2.size()/2;
      l2 = sort(l2.subList(0, half), l2.subList(half, l2.size()));
    }
    return merge(l1, l2);
  }

  public static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
    List<Integer> res = new ArrayList<Integer>();
    int arr1 = 0, arr2 = 0;
    while(arr1 != l1.size() && arr2 != l2.size()) {
      if (l1.get(arr1) < l2.get(arr2))  {
        res.add(l1.get(arr1++));
        //l1.remove(0);
      } else  {
        res.add(l2.get(arr2++));
        //l2.remove(0);
        inversions += l1.size() - arr1;
        if (l1.size() - arr1 < 0) {
          System.out.println("Negative inversions");
        }
      }
    }
    while (arr1 !=  l1.size()) {
      res.add(l1.get(arr1++));
    }
    while (arr2 != l2.size()) {
      res.add(l2.get(arr2++));
    }
    return res;
  }


}
