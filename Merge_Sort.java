import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge_Sort{ 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int arr1[] = Mer(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
    public static int[] Mer(int[] arr) {
        
        if (arr.length < 2) {
            return null;
        }
        int median = arr.length / 2;
        int[] leftarr = new int[median];
        int[] rightarr = new int[arr.length - median];
        for (int i = 0; i < median; i++) {
            leftarr[i] = arr[i];
        }
        for (int j = median; j < arr.length; j++) {
            rightarr[j - median] = arr[j];
        }
        Mer(leftarr);
        Mer(rightarr);
        return Merge(arr, leftarr, rightarr, median, arr.length - median);
    }

    public static int[] Merge(int[] massiv, int[] leftpart, int[] rightpart, int lenleftpart, int lenrightpart) {
        int indexleftpart = 0;
        int indexrightpart = 0;
        int indexmassiva = 0;
        while (indexleftpart < lenleftpart && indexrightpart < lenrightpart) {
            if (leftpart[indexleftpart] < rightpart[indexrightpart]) {
                massiv[indexmassiva++] = leftpart[indexleftpart++];
            } else {
                massiv[indexmassiva++] = rightpart[indexrightpart++];
            }
        }
        while (indexleftpart < lenleftpart) {
            massiv[indexmassiva++] = leftpart[indexleftpart++];
        }
        while (indexrightpart < lenrightpart) {
            massiv[indexmassiva++] = rightpart[indexrightpart++];
        }
        return massiv;
    }
}