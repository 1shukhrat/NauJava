import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class StreamTask {

    public static void start() {
        Random random = new Random();
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee(
                    "Employee " + i + 1,
                    random.nextInt(18, 50),
                    "Department " + i,
                    random.nextDouble(50000.0, 200000.0)
            );
            employeeList.add(employee);
        }
        System.out.println("Список работников:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        isThereEmployeeWithBigSalary(employeeList);
    }

    private static void isThereEmployeeWithBigSalary(List<Employee> employeeList) {
        Optional<Employee> employeeWithBigSalary = employeeList.stream()
                .filter(employee -> employee.getSalary() > 100000).findAny();
        if (employeeWithBigSalary.isPresent()) {
            System.out.println("Работник с зарплатой более 100000: " + employeeWithBigSalary.get());
        } else {
            System.out.println("Нет работников с зарплатой более 100000");
        }
    }

}
