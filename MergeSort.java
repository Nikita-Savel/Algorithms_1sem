import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort{ 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int arr1[] = mer(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
    public static int[] mer(int[] arr) {
        
        if (arr.length < 2) {
            return null;
        }
        int median = arr.length / 2;
        int[] leftArr = new int[median];
        int[] rightArr = new int[arr.length - median];
        for (int i = 0; i < median; i++) {
            leftArr[i] = arr[i];
        }
        for (int j = median; j < arr.length; j++) {
            rightArr[j - median] = arr[j];
        }
        mer(leftArr);
        mer(rightArr);
        return merge(arr, leftArr, rightArr, median, arr.length - median);
    }

    public static int[] merge(int[] massiv, int[] leftPart, int[] rightPart, int lenLeftPart, int lenRightPart) {
        int indexLeftPart = 0;
        int indexRightPart = 0;
        int indexMassiva = 0;
        while (indexLeftPart < lenLeftPart && indexRightPart < lenRightPart) {
            if (leftPart[indexLeftPart] < rightPart[indexRightPart]) {
                massiv[indexMassiva++] = leftPart[indexLeftPart++];
            } else {
                massiv[indexMassiva++] = rightPart[indexRightPart++];
            }
        }
        while (indexLeftPart < lenLeftPart) {
            massiv[indexMassiva++] = leftPart[indexLeftPart++];
        }
        while (indexRightPart < lenRightPart) {
            massiv[indexMassiva++] = rightPart[indexRightPart++];
        }
        return massiv;
    }
}