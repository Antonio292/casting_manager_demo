package app.demo;


import java.util.Scanner;

public class CastingMain {
    static String id = "";
    static String newStatus = "";
    public static void main(String[] args) {

        Casting casting = new Casting();
        Participant participant = buildParticipant();
        casting.registerParticipant(participant);
        participant = buildParticipant();
        casting.registerParticipant(participant);
        showParticipants(casting);

        gettingNewStatus();
        casting.updateStatus(newStatus,id);
        showParticipants(casting);

    }

    private static void showParticipants(Casting casting) {
        for (Participant participant: casting.getParticipants()) {
            System.out.println(participant);
        }
    }

    private static Participant buildParticipant() {
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Participant Id: ");
        id = scanner.nextLine();
        System.out.println("Enter new status for this Participant: ");
        newStatus = scanner.nextLine();
    }
}
