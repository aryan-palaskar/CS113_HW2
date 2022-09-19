import java.util.Scanner;

//Driver class to display a menu to the user with various functions
public class Driver {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        String question;

        Polynomial firstPoly = new Polynomial();
        Polynomial secondPoly = new Polynomial();

        //keeping displaying the menu to the user until they choose to exit
        while (true) {
            printMainMenu();
            choice = input.nextInt();

            //perform the necessary functions based on the user choice
            switch(choice) {

                //performing operations on the first polynomial
                case 1:
                    printPolyMenu();
                    choice = input.nextInt();

                    switch (choice) {

                        case 1:
                            do {
                                addTerm(input, firstPoly);
                                System.out.print("Would  you like to add another term (Y/N): ");
                                question = input.nextLine();
                            }while(question.equalsIgnoreCase("Y"));
                            break;

                        case 2:
                            removeTerm(input, firstPoly);
                            break;

                        case 3:
                                firstPoly.clear();
                                System.out.println("First Polynomial cleared successfully");
                                break;
                    }

                    break;

                    // performing operations on the second polynomial
                case 2:
                    printPolyMenu();
                    choice = input.nextInt();
                    switch (choice) {

                        case 1:
                            do {
                                addTerm(input, secondPoly);
                                System.out.print("Would  you like to add another term (Y/N): ");
                                question = input.nextLine();
                            }while(question.equalsIgnoreCase("Y"));
                            break;

                        case 2:
                            removeTerm(input, secondPoly);
                            break;

                        case 3:
                            secondPoly.clear();
                            System.out.println("Second Polynomial cleared successfully");
                            break;
                    }

                    break;

                    //displaying the first polynomial to the user
                case 3:
                    if(firstPoly.getTotalTerms() == 0) {
                        System.out.println("The polynomial is empty!");
                    }
                    else {
                        System.out.println(firstPoly);
                    }
                    break;

                //displaying the second polynomial to the user
                case 4:
                    if(secondPoly.getTotalTerms() == 0) {
                        System.out.println("The polynomial is empty!");
                    }
                    else {
                        System.out.println(secondPoly);
                    }
                    break;

                    //calculating and displaying the sum of the two polynomials
                case 5:
                    firstPoly.add(secondPoly);
                    System.out.println("The sum of the two polynomials is: " + firstPoly);

                    break;

                    //exiting the main menu
                case 6:
                    System.out.println("Thank you for using the program!");
                    System.exit(0);

            }

        }
    }

    //display method to print the main menu
    public static void printMainMenu() {
        System.out.println("==============================================================");
        System.out.println("Enter a choice from the below options:                       |");
        System.out.println("1. Edit the first polynomial                                 |");
        System.out.println("2. Edit the second polynomial                                |");
        System.out.println("3. Display the first polynomial                              |");
        System.out.println("4. Display the second polynomial                             |");
        System.out.println("5. Display the sum of the first and second polynomial        |");
        System.out.println("6. Exit the program                                          |");
        System.out.println("==============================================================");
        System.out.print("Enter your choice: ");
    }

    //display method for the second menu
    public static void printPolyMenu() {
        System.out.println("======================================================");
        System.out.println("What would you like to do with the polynomial: |");
        System.out.println("1. Add a term to the polynomial                      |");
        System.out.println("2. Remove a term from the polynomial                 |");
        System.out.println("3. Clear the polynomial                              |");
        System.out.println("======================================================");
        System.out.print("Enter your choice: ");
    }

    //add method to add a term to the polynomial
    public static void addTerm(Scanner input, Polynomial poly) {
        int coefficient, exp;
        System.out.print("Enter the coefficient: ");
        coefficient = input.nextInt();
        System.out.print("Enter the exponent: ");
        exp = input.nextInt();
        poly.addTerm(new Term(coefficient, exp));
        input.nextLine();
    }

    //remove method to remove a term from the polynomial
    public static void removeTerm(Scanner input, Polynomial poly) {
        System.out.println(poly);
        input.nextLine();
        System.out.print("Which term would you like to remove: ");
        String str = input.nextLine();
        for(int i = 0; i < poly.getTotalTerms(); i++)
        {
            Term other = new Term(str);
            if(other.equals(poly.getTerm(i))) {
                poly.remove(i);
                System.out.println("The term is removed successfully");
            }
        }
    }


}




