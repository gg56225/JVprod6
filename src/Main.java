import java.time.LocalDate;
import java.util.Arrays;

enum Gender {
    MALE, FEMALE, OTHER
}

class Customer {
    private String name;
    private Gender gender;

    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

enum Holiday {
    NO_HOLIDAY, NEW_YEAR, MARCH_8, FEBRUARY_23
}

class Employee {
    private String name;
    private Gender gender;

    public Employee(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Alice", Gender.FEMALE),
                new Employee("Bob", Gender.MALE),
                new Employee("Charlie", Gender.OTHER)
        };

        congratulateEmployees(employees, LocalDate.now());
    }

    public static void congratulateEmployees(Employee[] employees, LocalDate date) {
        Holiday holiday = getHoliday(date);

        for (Employee employee : employees) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println("С Новым Годом, " + employee.getName() + "!");
                    break;
                case MARCH_8:
                    if (employee.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 марта, " + employee.getName() + "!");
                    }
                    break;
                case FEBRUARY_23:
                    if (employee.getGender() == Gender.MALE) {
                        System.out.println("С 23 февраля, " + employee.getName() + "!");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public static Holiday getHoliday(LocalDate date) {
        if (date.equals(LocalDate.of(date.getYear(), 1, 1))) {
            return Holiday.NEW_YEAR;
        } else if (date.equals(LocalDate.of(date.getYear(), 3, 8))) {
            return Holiday.MARCH_8;
        } else if (date.equals(LocalDate.of(date.getYear(), 2, 23))) {
            return Holiday.FEBRUARY_23;
        } else {
            return Holiday.NO_HOLIDAY;
        }
    }
}
