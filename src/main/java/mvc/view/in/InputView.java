package mvc.view.in;

import mvc.common.Messages;
import mvc.domain.dto.GameInputs;


import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    public GameInputs getGameInputs() {
        String[] nameOfCars = read(Messages.INPUT_FOR_NAME_OF_CARS.valueOf()).split(",");
        int numberOfTrials = Integer.parseInt(read(Messages.INPUT_FOR_NUMBER_OF_TRIALS.valueOf()));

        return GameInputs.createGameInputs(nameOfCars, numberOfTrials);
    }

    private String read(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static InputView createInputView() {
        return new InputView();
    }
}
