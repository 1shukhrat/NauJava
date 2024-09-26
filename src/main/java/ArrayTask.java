import java.util.Arrays;
import java.util.Random;

public class ArrayTask {

    public static void start() {
        Random rand = new Random();
        int length = rand.nextInt(100) + 1;
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100 + 50 + 1) - 50;
        }
        int sumPositives = sumPositives(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Сумма положительных элементов равна " + sumPositives);
    }

    private static int sumPositives(int[] arr) {
        int sum = 0;
        for (int elem : arr) {
            if (elem > 0) {
                sum += elem;
            }
        }
        return sum;
    }
}
