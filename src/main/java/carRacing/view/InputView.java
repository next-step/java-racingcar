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

    public int userInteraction(String Message) {
        System.out.println(Message);
        return scanner.nextInt();
    }
}
