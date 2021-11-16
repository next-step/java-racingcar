package study.step_3.view;

import study.step_3.Input;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public Input start() {
        String numberOfCars = getNumberOfCars();
        String numberOfTrial = getNumberOfTrial();

        return new Input(numberOfCars, numberOfTrial);
    }

    private String getNumberOfCars() {
        System.out.println("자동차는 몇 대인가요?");
        return scanner.nextLine();
    }

    private String getNumberOfTrial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextLine();
    }
}
