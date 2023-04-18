package RacingCar.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Input {
    static InputView inputView = new InputView();
    static Scanner scanner = new Scanner(System.in);

    public String[] splitCarName(String input) {

        inputView.whatCarsName();

        return scanner.next().split(input);
    }

    public int InputTryCount() {

        inputView.howCountCar();

        return scanner.nextInt();
    }
}
