package RacingCar.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Input {
    static InputView inputView = new InputView();
    static Scanner scanner = new Scanner(System.in);

    public int InputCarNumber() {

        inputView.howManyCar();

        return scanner.nextInt();
    }

    public int InputTryCount() {

        inputView.howCountCar();

        return scanner.nextInt();
    }
}
