package racingcar.view;

import racingcar.model.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR_FOR_SPLIT = ",";

    public static List<CarName> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] carNames = input.split(SEPARATOR_FOR_SPLIT);

        return Arrays.stream(carNames)
                .map(String::trim)
                .map(CarName::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputNumberOfTries() {
        return inputNumber("시도할 회수는 몇 회 인가요?");
    }

    private static int inputNumber(String outputMessage) {
        System.out.println(outputMessage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
