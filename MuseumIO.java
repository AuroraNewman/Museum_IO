package csc8011;
/*
Modeled after code presented in tutorials by Dr. Nesbitt for Newcastle University CSC 8011.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MuseumIO {
    private static Museum museum1 = new Museum();
    public static void main(String[] args) {
        /**
         *  This while loop presents the user with 5 options. It calls methods detailed below the main.
         *  Errors are caught in the usual way to prevent user malfeasance and error. First, a try catch is used for the MuseumOptions.
         *  Second, a boolean value is set for false. When case 2 is chosen, a file is read and the value is set to true. Case 4 will only run if the
         *  boolean is true. This prevents a user from trying to print out statistics before uploading the file.
         */
        boolean done = false;
        boolean read=false;
        changeName();
        while(!done) {
            printMuseumOptions();
            try {
                Scanner userInput = new Scanner(System.in);
                int option = userInput.nextInt();
                switch (option) {
                    case 1: //User can change the name of the museum using method changeName().
                        changeName();
                        break;
                    case 2: //File is input using method readFile().
                        read=true;
                        readFile();
                        break;
                    case 3: //User can print a list of all exhibit items at the museum using method printExhibitList().
                        printExhibitList();
                        break;
                    case 4: //User can see a few statistics about exhibit items. Values formatted to two decimal places for ease of reading.
                        if (read==true) {
                            fetchStatistics();
                        } else {
                            System.out.println("Please verify the exhibit list has been properly uploaded. Thank you.");
                        }

                        break;
                    case 5: //User may exit the program.
                        done = true;
                        break;
                    default:
                        System.out.println("Please enter a number between 1 and 5.");
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Please choose a number between 1 and 5.");
        }

                }
            }
    /**
     * The user is presented with a list of options. The user chooses an option between one and five. Consequences of each option are detailed in the switch statement.
    */
    private static void printMuseumOptions() {
        System.out.println("Welcome to the museum interface.");
        System.out.println("Please choose from one of the following options");
        System.out.println("1: Change the name of the museum.");
        System.out.println("2: Read in a list of exhibit items.");
        System.out.println("3: Print out a list of the exhibit items.");
        System.out.println("4: Print out a summary of exhibit items.");
        System.out.println("5: Exit.");
    }
    /**
     *  User sets the name of the museum object.
     */
    private static void changeName() {
        try {
            System.out.println("Please enter the museum's name.");
            Scanner input2 = new Scanner(System.in);
            String newName = input2.nextLine();
            museum1.setMuseumName(newName);
            System.out.println("Museum name: " + museum1.getMuseumName());
        } catch  (InputMismatchException e) {
            System.out.println("That name is invalid. Sorry.");
        }
    }
    /**
     *  This method reads a file from a designated pathname. The method seeks the next line, splits the values by commas, and inserts each value into an array.
     *  The values are then used to create a new exhibit item which is added to the ArrayList using method addExhibit().
     */
    private static void readFile() {
        try {
            File input = new File("exhibits.csv");
            Scanner s = new Scanner(input);
            s.nextLine();
            while (s.hasNext()) {
                String[] line = s.nextLine().split(",");
                Exhibit e = new Exhibit(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]));
                museum1.addExhibit(e);
            }
            System.out.println("Read in " + museum1.getExhibitList().size() + " exhibit items.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please enter a valid file.");
        }
    }

    /**
     *  This method first checks that the exhibit list exists (i.e., size is greater than zero). If that is true, then it loops through the array list
     *  and prints out each exhibit item. If it is false, the user is notified that there are no items in the exhibit.
     */
    private static void printExhibitList() {
        if (museum1.getExhibitList().size() > 0) {
            for (Exhibit item : museum1.getExhibitList()) {
                System.out.println("Exhibit ID: " + item.getExhibitID() + " Description: " + item.getDescription() + " Year Acquired: " + item.getYearAcquired() + " Estimated Value: US$" + item.getValue());
            }
        }
        else {
            System.out.println("There are no items in the exhibit.");
        }
    }

    /**
     * Fetch statistics on items in the exhibit, including average, highest value, and first acquired item.
     */
    private static void fetchStatistics() {
        Formatter formattedHighValue = new Formatter();
        formattedHighValue.format("%.2f", museum1.getHighestValue().getValue());
        Formatter formattedAverage = new Formatter();
        formattedAverage.format("%.2f", museum1.getAverage());

        System.out.println("The statistics on highest value, first exhibit acquired and average value of exhibits:");
        System.out.println("Highest value exhibit: " + museum1.getHighestValue().getDescription() + ", US$" + formattedHighValue);
        System.out.println("First exhibit acquired: " + museum1.getOldestItem().getDescription() + " (acquired " + museum1.getOldestItem().getYearAcquired() + ")");
        System.out.println("Average value of all exhibits: US$" + formattedAverage);
    }

}