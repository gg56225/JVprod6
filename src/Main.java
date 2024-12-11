import java.util.Arrays;

class Employee {
    private int year;
    private int month;
    private int day;
    private double salary;

    public Employee(int year, int month, int day, double salary) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.salary = salary;
    }

    public int compareDates(Employee other) {
        return Integer.compare(this.year * 10000 + this.month * 100 + this.day,
                other.year * 10000 + other.month * 100 + other.day);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    public Manager(int year, int month, int day, double salary) {
        super(year, month, day, salary);
    }

    public static void raiseSalary(Employee[] employees, double percent) {
        for (Employee employee : employees) {
            if (!(employee instanceof Manager)) {
                double newSalary = employee.getSalary() * (1 + percent / 100);
                employee.setSalary(newSalary);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(2020, 5, 15, 50000);
        Employee emp2 = new Employee(2019, 3, 10, 55000);
        Manager mgr = new Manager(2018, 7, 20, 70000);

        Employee[] employees = {emp1, emp2, mgr};

        Manager.raiseSalary(employees, 10);

        for (Employee employee : employees) {
            System.out.println("Salary: " + employee.getSalary());
        }
    }
}
