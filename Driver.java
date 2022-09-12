import java.util.Scanner;

public class Driver {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        Polynomial firstPoly = new Polynomial();
        Polynomial secondPoly = new Polynomial();

        while (true) {
            System.out.println("==============================================================");
            System.out.println("Enter a choice from the below options:                       |");
            System.out.println("1. Edit the first polynomial (clear, create, and add terms)  |");
            System.out.println("2. edit the second polynomial (clear, create, and add terms) |");
            System.out.println("3. Display the sum of the first and second polynomial        |");
            System.out.println("4. Exit the program                                          |");
            System.out.println("==============================================================");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch(choice) {

                case 1:
                   editPolynomial(input, firstPoly);

                    switch (choice) {

                        case 1:


                        case 2:


                        case 3:

                    }

                    break;

                case 2:

                    System.out.println("What would you like to do with the second polynomial: ");
                    System.out.println("1. Create a new polynomial");
                    System.out.println("2. Add terms of the polynomial");
                    System.out.println("3. Clear the polynomial");
                    System.out.print("Enter your choice: ");
                    choice = input.nextInt();

                    break;

                case 3:
                    System.out.println("The sum of the two polynomials is: ");
                    break;

                case 4:
                    System.out.println("Thank you for using the program!");
                    System.exit(0);

            }

        }
    }

    public static void editPolynomial(Scanner input, Polynomial other) {
        System.out.println("What would you like to do with the polynomial: ");
        System.out.println("1. Create a new polynomial");
        System.out.println("2. Add terms of the polynomial");
        System.out.println("3. Clear the polynomial");
        System.out.println("4. Display the polynomial");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        input.nextLine();
        switch(choice) {
            case 1:
                System.out.println("Enter the polynomial as a string: ");
                String str = input.nextLine();
                other.createPoly(str);
                break;

            case 2:


            case 3:

            case 4:
                for(int i = 0; i < other.getNumTerms(); i++) {
                    System.out.println(other);
                }
                break;
        }
    }

}




