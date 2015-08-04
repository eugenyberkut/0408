package logic;

import java.util.Scanner;

/**
 * Created by Yevhen on 04.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Person p1 = new Person("Иванов", 1000, "1234567");
        Person p2 = new Person("Петров", 1100, "1111117");
        Person p3 = new Person("Содоров", 2000, "2222567");
        Person p4 = new Person("Федоренко", 990, "3333333");

        Person[] persons = {p1, p2, p3, p4};

        int sum = sumZP(persons);
        System.out.println("sum = " + sum);

        Person maxPerson = maxZP(persons);
        System.out.println(maxPerson);

        Scanner in = new Scanner(System.in);
        String end = in.nextLine();
        printPersonsEnded(persons, end);
        System.out.println("========");
        Person[] personsEnded = findPersonsEnded(persons, end);
        System.out.println("Найдено: " + personsEnded.length);
        print(personsEnded);
        System.out.println("========");
        print(personsWithZPgreaterThenAVG(persons));
    }

    private void print(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private void printPersonsEnded(Person[] persons, String end) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getPhone().endsWith(end)) {
                System.out.println(persons[i]);
            }
        }
    }

    public Person[] findPersonsEnded(Person[] persons, String end) {
        int n = countPersonsEnded(persons, end);
        Person[] result = new Person[n];
        int k = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getPhone().endsWith(end)) {
                result[k] = persons[i];
                k++;
            }
        }
        return result;
    }

    private int countPersonsEnded(Person[] persons, String end) {
        int result = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getPhone().endsWith(end)) {
                result++;
            }
        }
        return result;
    }

    public Person maxZP(Person[] persons) {
        Person result = persons[0];
        for (int i = 1; i < persons.length; i++) {
            if (result.getZp() < persons[i].getZp()) {
                result = persons[i];
            }
        }
        return result;
    }

    public int sumZP(Person[] persons) {
        int s = 0;
        for (int i = 0; i < persons.length; i++) {
            s += persons[i].getZp();
        }
        return s;
    }

    public Person[] personsWithZPgreaterThenAVG(Person[] persons){
        double avg = avgZP(persons);
        int n = countPersonsWithZPgreaterThen(persons, avg);
        Person[] result = new Person[n];
        int k = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getZp()>avg) {
                result[k++] = persons[i];
                // k++;
            }
        }
        return result;
    }

    // Это метод
    private int countPersonsWithZPgreaterThen(Person[] persons, double amount) {
        int result = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getZp()>amount) {
                result++;
            }
        }
        return result;
    }

    private double avgZP(Person[] persons) {
        return 1.0 * sumZP(persons) / persons.length;
    }
}
