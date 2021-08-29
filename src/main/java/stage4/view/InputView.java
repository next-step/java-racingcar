package stage4.view;

import stage4.dto.InputValue;
import stage4.exception.TooLongCarNameException;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public InputValue input() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = scanner.next();
        final String[] splitNames = splitName(carNames);
        validateCarNames(splitNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfTries = scanner.nextInt();
        System.out.println();

        return new InputValue(splitNames, numberOfTries);
    }

    private void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            checkLengthOfCarName(carName);
        }
    }

    private void checkLengthOfCarName(String carName) {
        if (carName.length() > 5) {
            throw new TooLongCarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private String[] splitName(String carNames) {
        return carNames.split(",");
    }
}
