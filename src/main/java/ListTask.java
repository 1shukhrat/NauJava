import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListTask {

    public static void start() {
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();
        int length = random.nextInt(20);
        for (int i = 0; i < length; i++) {
            numbers.add(random.nextDouble() * 100);
        }
        System.out.println("Исходный массив: " + numbers);
        insertionSort(numbers);
    }

    private static void insertionSort(List<Double> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            Double current = numbers.get(i);
            int j = i - 1;
            while (j >= 0 && numbers.get(j) > current) {
                numbers.set(j + 1, numbers.get(j));
                j--;
            }
            numbers.set(j + 1, current);
        }
        System.out.println("Отсортированный массив: " + numbers);
    }
}
