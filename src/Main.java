import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            System.out.println("Enter information for a person (or type 'exit' to finish):");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            if (age < 0 || salary < 0) {
                System.out.println("Age and salary cannot be negative. Please enter valid information.");
            } else {
                Person person = new Person(name, age, salary);
                people.add(person);
            }
        }

        scanner.close();

        // Calculate and display average salary and age
        double totalSalary = 0;
        int totalAge = 0;

        for (Person person : people) {
            totalSalary += person.getSalary();
            totalAge += person.getAge();
        }

        double averageSalary = totalSalary / people.size();
        double averageAge = (double) totalAge / people.size();

        System.out.println("\nSurvey Results:");
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Average Age: " + averageAge);
    }
}
