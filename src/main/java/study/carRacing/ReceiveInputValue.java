package study.carRacing;

import java.util.Scanner;

public class ReceiveInputValue {

    private Scanner scanner;
    private final String CAR_INPUT_MESSAGE = "Enter the number of cars.";
    private final String ROUND_INPUT_MESSAGE = "Enter how many rounds are we going to do.";

    public ReceiveInputValue() {
        this.scanner = new Scanner(System.in);
    }

    public int receiveInputValueForCar() {
        System.out.println(CAR_INPUT_MESSAGE);
        return this.scanner.nextInt();
    }

    public int receiveInputValueForRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return this.scanner.nextInt();
    }

}
