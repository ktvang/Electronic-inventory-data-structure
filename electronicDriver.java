import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for testing the electronic sorted array set.
 *
 * <p>Reads electronic inventory records from a user-specified
 * file, creates the appropriate electronic objects, and tests
 * insertion, searching, retrieval, removal, and category filtering.</p>
 */
public class electronicDriver {

    /**
     * Reads inventory data and tests the electronic sorted set.
     *
     * @param args command-line arguments
     * @throws FileNotFoundException if the specified input file
     *         cannot be found
     */
    public static void main(String[] args)
            throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = input.nextLine();

        File file = new File(fileName);
        Scanner fileScan = new Scanner(file);

        electronicSortedArraySet set =
                new electronicSortedArraySet();

        // Read and process each inventory record.
        while (fileScan.hasNextLine()) {

            String line = fileScan.nextLine();

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            char type = parts[0].charAt(0);

            // Create and insert a phone record.
            if (type == 'P') {

                String eID = parts[1];
                Integer electronicNum =
                        Integer.parseInt(parts[2]);
                Double price =
                        Double.parseDouble(parts[3]);
                Boolean has5G =
                        Boolean.parseBoolean(parts[4]);

                phone p =
                        new phone(eID,
                                  electronicNum,
                                  price,
                                  has5G);

                set.insert(p);
            }

            // Create and insert a laptop record.
            else if (type == 'L') {

                String eID = parts[1];
                Integer electronicNum =
                        Integer.parseInt(parts[2]);
                Double price =
                        Double.parseDouble(parts[3]);
                Double screenSize =
                        Double.parseDouble(parts[4]);

                laptop l =
                        new laptop(eID,
                                   electronicNum,
                                   price,
                                   screenSize);

                set.insert(l);
            }

            // Create and insert a camera record.
            else if (type == 'C') {

                String eID = parts[1];
                Integer electronicNum =
                        Integer.parseInt(parts[2]);
                Double price =
                        Double.parseDouble(parts[3]);
                Integer megapixels =
                        Integer.parseInt(parts[4]);

                camera c =
                        new camera(eID,
                                   electronicNum,
                                   price,
                                   megapixels);

                set.insert(c);
            }

            // Create and insert a general electronic record.
            else if (type == 'X') {

                String eID = parts[1];
                Integer electronicNum =
                        Integer.parseInt(parts[2]);
                Double price =
                        Double.parseDouble(parts[3]);

                electronic e =
                        new electronic(eID,
                                       electronicNum,
                                       price);

                set.insert(e);
            }
        }

        // Display the complete sorted inventory.
        System.out.println("\nSORTED SET");
        System.out.println("--------------------");
        System.out.println(set);

        // Test searching for existing and non-existing items.
        System.out.println("\nINDEX OF TESTS");

        electronic e1 =
                new electronic("JBLSpeaker",
                               8,
                               199.99);

        System.out.println(
                "JBLSpeaker index: "
                        + set.indexOf(e1));

        electronic e2 =
                new electronic("FakeItem",
                               99,
                               99.99);

        System.out.println(
                "FakeItem index: "
                        + set.indexOf(e2));

        // Test retrieving items by index.
        System.out.println("\nGRAB TESTS");

        System.out.println("Grab position 0:");
        System.out.println(set.grab(0));

        System.out.println("Grab position 50:");
        System.out.println(set.grab(50));

        // Test removing existing and non-existing items.
        System.out.println("\nREMOVE TESTS");

        System.out.println(set.remove(e1));
        System.out.println(set.remove(e2));

        System.out.println("\nSET AFTER REMOVE");
        System.out.println(set);

        // Test filtering the inventory by category.
        System.out.println("\nPHONE CATEGORY");
        System.out.println(set.categorySet("Phone"));

        System.out.println("\nLAPTOP CATEGORY");
        System.out.println(set.categorySet("Laptop"));

        fileScan.close();
        input.close();
    }
}