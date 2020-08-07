package racingcar;

import racingcar.common.Messages;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameInputs createUserArgument() {
        System.out.println(Messages.INPUT_FOR_NAME_OF_CARS.valueOf());
        String line = this.scanner.nextLine();

        String[] names = line.split(",");

        System.out.println(Messages.INPUT_FOR_NUMBER_OF_TRIALS.valueOf());
        int numberOfTrials = this.scanner.nextInt();

        return GameInputs.createGameInputs(names, numberOfTrials);
    }
}
