package RacingCar.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Input {
    static InputView inputView = new InputView();
    static Scanner scanner = new Scanner(System.in);

    public String[] splitCarName(String split) {

        inputView.whatCarsName();

        String[] result = scanner.next().split(split);

        checkCarNameLength(result);

        return result;
    }

    public void checkCarNameLength(String[] result) {
        for (String name : result)
            if (name.length() > 5) throw new IllegalArgumentException(name + "의 자동차 이름은 5자 이하여야 합니다.");
    }

    public int InputTryCount() {

        inputView.howCountCar();

        return scanner.nextInt();
    }
}
