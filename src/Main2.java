import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        lavPerson p = new lavPerson();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            int input = scanner.nextInt();
            switch (input) {
                case 0: quit = true;
                    break;
                case 1:
                    System.out.println("Indtast navn");
                    String name = scanner.next();
                    System.out.println("Indtast alder");
                    int age = scanner.nextInt();
                    Person person = new Person(name, age);
                    p.createUser(person);
                    break;
                case 2:
                    p.listOfUsers();
            }
        }
    }
}

class lavPerson {

    List<Person> persons = new ArrayList<>();

    public void createUser(Person user) {
        persons.add(user);

    }

    public void listOfUsers() {
        if (persons.size() < 1) {
            System.out.println("Ingen personer");
        }
        for (Person person : persons) {
            System.out.println("Navn = " + person.getNavn() + " Alder = " + person.getAlder());
        }
    }
}

