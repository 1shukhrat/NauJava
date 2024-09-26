import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. Работа с массивом - сумма положительных чисел
                    2. Работа со списком - Сортировка вставками
                    3. Stream API - Определить наличие работника с ЗП более 100 000
                    4. HTTP и JSON - Вывести название хоста
                    5. Реализация интерфейса "Task" - Поиск свободных порт
                    6. Завершение работы
                    """);
            System.out.print("Выберите задачу: ");
            int taskNumber = scanner.nextInt();
            switch (taskNumber) {
                case 1 -> ArrayTask.start();
                case 2 -> ListTask.start();
                case 3 -> StreamTask.start();
                case 4 -> HTTPTask.start();
                case 5 -> {
                    System.out.println("""
                            Будет запущен поиск свободных портов.
                            Для остановки поиска и по окончании поиска нужно будет ввести в консоль "Q"
                            """);
                    System.out.print("Введите границы поиска портов через пробел:");
                    scanner.nextLine();
                    String[] ports = scanner.nextLine().split(" ");
                    int start = Integer.parseInt(ports[0]);
                    int end = Integer.parseInt(ports[1]);
                    Task task = new TaskImpl(start, end);
                    task.start();
                    while (true) {
                        if (scanner.next().equalsIgnoreCase("q")) {
                            task.stop();
                            break;
                        }
                    }
                }
                case 6 -> { return; }
                default -> System.out.println("Неверный номер задачи");
            }
            System.out.println();
        }
    }
}
