package study.race.view;

import java.util.Scanner;

public class ReceiveInputValue {

    private Scanner scanner;
    private final String CAR_STRING_INPUT_MESSAGE = "Enter the names of the cars to race(Separation by comma).";
    private final String ROUND_INPUT_MESSAGE = "Enter how many rounds are we going to do.";

    public ReceiveInputValue() {
        this.scanner = new Scanner(System.in);
    }

    public String receiveInputValueForCarNames() {
        System.out.println(CAR_STRING_INPUT_MESSAGE);
        return this.scanner.nextLine();
    }

    public int receiveInputValueForRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return this.scanner.nextInt();
    }
}
