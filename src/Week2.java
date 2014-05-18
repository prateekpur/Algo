import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pooja on 5/17/2014.
 */
public class Week2 {
  public static int comparisons;
  public static void main(String args[]) throws IOException {
    List<Integer> k = new ArrayList<Integer>();
    BufferedReader reader;
    reader=new BufferedReader(new FileReader("C:\\Prateek\\algo\\Algo\\src\\QuickSort.txt"));
    for (int i = 1; i <= 10000; ++i) {
      k.add(Integer.parseInt(reader.readLine()));
    }
    reader.close();
    Integer []k1 =new Integer[k.size()];
    sortMidPivot(k.toArray(k1), 0 , k.size()-1);
    System.out.println("Compare : " + comparisons);
  }

  public static void sortLastPivot(Integer[] li, int start, int end) {
    // swap first and last
    int tmp = li[start];
    li[start] = li[end];
    li[end] = tmp;
    comparisons += end - start;
    //System.out.println("start: " + start + " : end : "+end);
    StringBuffer st = new StringBuffer("array : ");
    for (int i : li)  {
      st.append(i);
      st.append(" ,");
    }
    //System.out.println(st.toString());
    boolean swaps = false;
    if (start == end) return;
    int pivot = li[start], pivotpos = start;
    //less is the boundary between partitioned and un-partitioned array
    int partiotionPos = start+1;
    for (int i = start+1; i <= end; ++i) {
      if(li[i] < pivot) {
        swaps = true;
        //swap
        tmp = li[i];
        li[i] = li[partiotionPos];
        li[partiotionPos] = tmp;
        ++partiotionPos;
      }
    }
    // if no swaps then pivot is in the right position so do not move pivot, sort the array after the pivot
    if (!swaps) {
      sortLastPivot(li, start+1, end);
    } else  {
      // move pivot to the correct position
      li[pivotpos] = li[partiotionPos-1];
      li[partiotionPos-1] = pivot;
      // if array has 2 elements then no recursion is needed
      sortLastPivot(li, start, partiotionPos-2);
      if (partiotionPos < end)  {
        sortLastPivot(li, partiotionPos, end);
      }
      return;
    }
  }

  // pivot - element 0
  public static void sortFirstPivot(Integer[] li, int start, int end) {
    comparisons += end - start;
    /*System.out.println("start: " + start + " : end : "+end);
    StringBuffer st = new StringBuffer("array : ");
    for (int i : li)  {
      st.append(i);
      st.append(" ,");
    }
    System.out.println(st.toString());*/
    boolean swaps = false;
    if (start == end) return;
    int pivot = li[start], pivotpos = start;
    //less is the boundary between partitioned and un-partitioned array
    int partiotionPos = start+1;
    for (int i = start+1; i <= end; ++i) {
      if(li[i] < pivot) {
        swaps = true;
        //swap
        int tmp = li[i];
        li[i] = li[partiotionPos];
        li[partiotionPos] = tmp;
        ++partiotionPos;
      }
    }
    // if no swaps then pivot is in the right position so do not move pivot, sort the array after the pivot
    if (!swaps) {
      sortFirstPivot(li, start+1, end);
    } else  {
      // move pivot to the correct position
      li[pivotpos] = li[partiotionPos-1];
      li[partiotionPos-1] = pivot;
      // if array has 2 elements then no recursion is needed
      sortFirstPivot(li, start, partiotionPos-2);
      if (partiotionPos < end)  {
        sortFirstPivot(li, partiotionPos, end);
      }
      return;
    }
  }

  public static void sortMidPivot(Integer[] li, int start, int end) {
    if (start == end) return;
    comparisons += end - start;
    /*System.out.println("start: " + start + " : end : "+end);
    StringBuffer st = new StringBuffer("array : ");
    for (int i : li)  {
      st.append(i);
      st.append(" ,");
    }
    System.out.println(st.toString());*/
    boolean swaps = false;
    int pivot=li[start],pivotpos=start;
    int size = end - start+1;
    int mid = ((end - start) / 2) + start;
    if ((li[start] < li[mid] && li[mid] < li[end]) || li[start] > li[mid] && li[mid] > li[end]) {
      pivotpos = mid;
    }
    if ((li[start] < li[end] && li[end] < li[mid]) || li[start] > li[end] && li[end] > li[mid]) {
      pivotpos = end;
    }
    if ((li[mid] < li[start] && li[start] < li[end]) || li[mid] > li[start] && li[start] > li[end]) {
      pivotpos = start;
    }

    // swap mid and start
    pivot = li[pivotpos];
    li[pivotpos] = li[start];
    li[start] = pivot;
    pivotpos = start;
    //less is the boundary between partitioned and un-partitioned array
    int partiotionPos = start+1;
    for (int i = start+1; i <= end; ++i) {
      if(li[i] < pivot) {
        swaps = true;
        //swap
        int tmp = li[i];
        li[i] = li[partiotionPos];
        li[partiotionPos] = tmp;
        ++partiotionPos;
      }
    }
    // if no swaps then pivot is in the right position so do not move pivot, sort the array after the pivot
    if (!swaps) {
      sortMidPivot(li, start+1, end);
    } else  {
      // move pivot to the correct position
      li[pivotpos] = li[partiotionPos-1];
      li[partiotionPos-1] = pivot;
      // if array has 2 elements then no recursion is needed
      sortMidPivot(li, start, partiotionPos-2);
      if (partiotionPos < end)  {
        sortMidPivot(li, partiotionPos, end);
      }
      return;
    }
  }

}
