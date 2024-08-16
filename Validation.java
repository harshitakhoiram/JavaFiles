import java.io.*;

// Define the custom exception
class SelectionException extends Exception {
    SelectionException() {
        super("You are not allowed");
    }
}

// Define the Details class
class Details {
    String name;
    int age;

    Details(String sname, int age) {
        this.name = sname;
        this.age = age;
    }

    public void validate(int age) {
        try {
            if (age < 18 || age > 55) {
                throw new SelectionException();
            } else {
                System.out.println("Registered Successfully");
            }
        } catch (SelectionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void display() {
        System.out.println("Name= " + name);
        System.out.println("Age= " + age);
    }
}

// Define the Validation class with the main method
public class Validation {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name:");
        String name = in.readLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(in.readLine());

        Details obj = new Details(name, age);
        obj.validate(age);
        obj.display();
    }
}
