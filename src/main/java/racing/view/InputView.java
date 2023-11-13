package racing.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getNumberOfCar() {
        return scanner.nextInt();
    }

    public static int getNumberOfRound() {
        return scanner.nextInt();
    }

    public static List<String> getCarNames() {
        List<String> carNames = List.of(scanner.nextLine().split(","));
        carNames.forEach(name -> {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
            }
        });

        return carNames;
    }
}
