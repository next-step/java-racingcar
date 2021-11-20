package carracing;

import carracing.domain.CarRacing;
import carracing.exception.CarNameFormatException;
import carracing.view.InputView;

import java.util.Scanner;

import static carracing.domain.CarRacing.QUESTION_CAR_NAMES;
import static carracing.domain.CarRacing.QUESTION_TRY_COUNT;

public class Main {

    public static void main(String[] args) throws CarNameFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(QUESTION_CAR_NAMES);
        String carNames = scanner.nextLine();

        System.out.println(QUESTION_TRY_COUNT);
        String tryCount = scanner.nextLine();

        CarRacing carRacing = new CarRacing();
        carRacing.racingStart(new InputView(carNames, tryCount));
    }
}
