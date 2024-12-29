package app.demo;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Slf4j
@ToString
public class CastingManager {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, Casting> castings = new HashMap<>();

    public static void main(String[] args) {
        byte choice = 0;
        boolean run = true;
        while (run) {
            showMenu();
            choice = scanner.nextByte();
            switch (choice) {
                case 1 -> {
                    Casting casting = buildCasting();
                    registerCasting(casting);
                }
                case 2 -> {
                    boolean runCasting = true;
                    byte choiceCasting;
                    Casting casting = findCasting();
                    // if casting == null
                    while (runCasting) {
                        showCastingMenu();
                        choiceCasting = scanner.nextByte();
                        switch (choiceCasting) {
                            case 1 -> {
                                Participant participant = buildParticipant();
                                casting.registerParticipant(participant);
                            }
                            case 2 -> {
                                StatusUpdateInfo statusUpdateInfo = acceptNewStatus();
                                casting.updateStatus(statusUpdateInfo);
                            }
                            case 3 -> {
                                casting.showParticipants();
                            }
                            case 4 -> {
                                runCasting = false;
                                System.out.println("You are exiting casting menu");
                                log.info("Quit the casting menu");
                            }
                            default -> {
                                System.out.println("Input is incorrect");
                                log.warn("attempt to incorrect Casting menu input");
                            }
                        }
                    }
                }
                case 3 -> {
                    showCastings();
                }
                case 4 -> {
                    run = false;
                    System.out.println("You are exiting the program");
                    log.info("Quit the program");
                }
                default -> {
                    System.out.println("Input is incorrect");
                    log.warn("attempt to incorrect Main menu input");
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
        Casting casting = new Casting();
        scanner.nextLine();

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
        castings.put(casting.getId(), casting);
        System.out.println("Casting was added");
        log.info("Casting was added");
    }

    public static Casting findCasting() {
        scanner.nextLine();
        System.out.println("Enter casting Id: ");
        String idToFind = scanner.nextLine();

        Casting casting = castings.get(idToFind);
        System.out.println(casting);
        log.info("attempt find Casting");

        return casting;
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

    private static StatusUpdateInfo acceptNewStatus() {
        StatusUpdateInfo statusUpdateInfo = new StatusUpdateInfo();
        scanner.nextLine();
        System.out.println("Enter Participant Id: ");
        String id = scanner.nextLine();
        statusUpdateInfo.setId(id);
        System.out.println("Enter new status for this Participant: ");
        String newStatus = scanner.nextLine();
        statusUpdateInfo.setNewStatus(newStatus);
        return statusUpdateInfo;
    }

    private static void showCastings() {
        for (Map.Entry<String, Casting> entry : castings.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void showCastingMenu() {
        System.out.println("1. Add participant");
        System.out.println("2. Change participant status");
        System.out.println("3. View participants");
        System.out.println("4. Quit \n");
    }
}
