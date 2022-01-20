package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Console {

    private int tryCount;
    private List<String> carNames;

    public Console() {
        setRacingCarNames();
        setTryCount();
    }

    private void setRacingCarNames() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        carNames = Arrays.asList(scanner.nextLine().split(","));

        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private void setTryCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("시도할 횟수는 몇 회인가요?");

        tryCount = Integer.parseInt(scanner.nextLine());
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
