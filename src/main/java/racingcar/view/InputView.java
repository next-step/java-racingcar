package racingcar.view;

import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.TryCount;
import racingcar.exception.CarNameInputException;
import racingcar.exception.TryCountInputException;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static CarNames processCarNames() {
        try {
            return readCarNames();
        } catch (CarNameInputException e) {
            System.out.println(e.getMessage());
            return processCarNames();
        }
    }

    private static CarNames readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = SCANNER.nextLine();
        return splitToCarNames(input);
    }

    private static CarNames splitToCarNames(String input) {
        String[] carNames = input.split(",");
        return new CarNames(Arrays.stream(carNames)
                .map(CarName::new)
                .collect(Collectors.toList()));
    }

    public static TryCount processTryCount() {
        try {
            return readTryCount();
        } catch (TryCountInputException e) {
            System.out.println(e.getMessage());
            return processTryCount();
        }
    }

    private static TryCount readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = SCANNER.nextLine();
        return new TryCount(input);
    }
}
