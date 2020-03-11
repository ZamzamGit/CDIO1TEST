import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Person p;
    static List<Person> person = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        File file = new File("user.data");
        if (file.exists()) {
            person = readFromDisk();
        }

        boolean quit = false;
        while (!quit) {
            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Indtast navn");
                    String name = scanner.next();
                    System.out.println("Indtast alder");
                    int age = scanner.nextInt();
                    p = new Person(name, age);
                    addPerson(p);
                    writeToDisk(person);
                    break;
                case 2:
                    System.out.println("Indtast navn på personen du vil fjerne");
                    String navn = scanner.next();
                    removePerson(navn);
                    writeToDisk(person);
                    break;
                case 3:
                    showList();
                    break;
            }
        }
    }

    public static void addPerson(Person p) {
        person.add(p);
    }

    public static void removePerson(String name)  {
        boolean foundPerson = false;
        for (int i = 0; i < person.size(); i++) {
            if ((name.equals(person.get(i).getNavn()))) {
                System.out.println("Person fjernet");
                person.remove(person.get(i));
                foundPerson = true;
            }

        }
        if (!foundPerson){
            System.out.println("Ingen med navnet");
        }
    }




    public static void showList() {
        for (Person person : person) {
            System.out.println("Navn = " + person.getNavn() + " Alder = " + person.getAlder());
        }
    }

    private static void writeToDisk(List<Person> list){
        try {
            FileOutputStream fos = new FileOutputStream("user.data");
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(list);
            outputStream.close();
            fos.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static List<Person> readFromDisk(){
        List<Person> list = null;
        try {
            ObjectInputStream temp
                    = new ObjectInputStream(new FileInputStream("user.data"));
            list = (List<Person>) temp.readObject();
            temp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
