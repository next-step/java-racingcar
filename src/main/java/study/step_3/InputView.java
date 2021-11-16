package study.step_3;

import java.util.Scanner;

public class InputView {
    public Input print() {
        Scanner scanner = new Scanner(System.in);

        String numberOfCars = scanner.nextLine();
        String numberOfTrial = scanner.nextLine();

        return new Input(numberOfCars, numberOfTrial);
    }
}
