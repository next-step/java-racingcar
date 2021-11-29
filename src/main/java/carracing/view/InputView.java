package carracing.view;

import carracing.cars.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static List<CarName> inputCarNames() {
        String input = stringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = input.split(",");
        return Arrays.stream(names)
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    public static int inputRound() {
        return intInput("시도할 회수는 몇 회 인가요?");
    }

    private static int intInput(String message) {
        print(message);
        return scanner.nextInt();
    }

    private static String stringInput(String message) {
        print(message);
        return scanner.next();
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
