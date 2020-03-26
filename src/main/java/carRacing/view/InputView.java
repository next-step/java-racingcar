package carRacing.view;

import java.util.Scanner;


public class InputView {

    Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    static public InputView readyToInteraction() {
        return new InputView();
    }

    public int userInteractionNumber(String Message) {
        System.out.println(Message);
        return scanner.nextInt();
    }

    public String userInteractionString(String Message) {
        System.out.println(Message);
        return scanner.nextLine();
    }
}
