package app.demo;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
@Slf4j
@ToString
public class CastingManager {
    static String idToFind = "";
    static String id = "";
    static String newStatus = "";
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Casting> castings = new HashMap<>();

    public static void main(String[] args) {
        int choice = 0;
        boolean run = true;
        while (run) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    registerCasting(buildCasting());
                }
                case 2 -> {
                    findCasting();

                }
                case 3 -> {
                            showCastings();
                }
                case 4 -> {
                    run = false;
                    log.info("Quit the program");
                }

            }

        }
    }

    public static void showMenu() {
        System.out.println("Menu: ");
        System.out.println("1. New Casting");
        System.out.println("2. Select Casting");
        System.out.println("3. View Castings");
        System.out.println("4. Quit \n");
    }

    public static Casting buildCasting() {
        scanner.nextLine();
        Casting casting = new Casting();

        System.out.println("Enter Casting Id: ");
        String id = scanner.nextLine();
        casting.setId(id);

        System.out.println("Enter Casting name: ");
        String name = scanner.nextLine();
        casting.setName(name);

        System.out.println("Enter Casting description: ");
        String description = scanner.nextLine();
        casting.setDescription(description);

        System.out.println("Enter Casting location: ");
        String location = scanner.nextLine();
        casting.setLocation(location);

        return casting;
    }

    public static void registerCasting(Casting casting) {
        castings.put(casting.getId(),casting);
        System.out.println("Casting was added");
        log.info("Casting was added");
    }

    public static void findCasting() {
        scanner.nextLine();
        System.out.println("Enter casting Id: ");
        idToFind = scanner.nextLine();
        if (castings.containsKey(idToFind)){
            System.out.println(castings.get(idToFind));
        }
        log.info("attempt find Casting");
    }

    private static Participant buildParticipant() {
        scanner.nextLine();
        Participant participant = new Participant();
        System.out.println("Enter Participant Id: ");
        String id = scanner.nextLine();
        participant.setId(id);

        System.out.println("Enter Participant Name: ");
        String name = scanner.nextLine();
        participant.setName(name);

        System.out.println("Enter Participant Status: ");
        String status = scanner.nextLine();
        participant.setStatus(status);
        return participant;
    }

    private static void gettingNewStatus() {
        scanner.nextLine();
        System.out.println("Enter Participant Id: ");
        id = scanner.nextLine();
        System.out.println("Enter new status for this Participant: ");
        newStatus = scanner.nextLine();

    }

    private static void showCastings() {
        for (Map.Entry<String, Casting> entry : castings.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

}
