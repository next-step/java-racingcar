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
        String[] inputs = input.split(SEPARATOR_FOR_SPLIT);

        return Arrays.stream(inputs)
                .map(String::trim)
                .map(CarName::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputNumberOfTries() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
