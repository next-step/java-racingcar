package racing.view.input;

import racing.dto.RaceInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public RaceInfo racingInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carInfo = getString();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfAttempt = getInt();

        return new RaceInfo(carInfo, numOfAttempt);
    }

    private String getString() {
        String value = SCANNER.next();
        while (true) {
            if (!value.isBlank()) {
                return value;
            }
            System.out.println("입력 값으로 공백은 허용되지 않습니다.");
        }

    }

    private int getInt() {
        while (true) {
            try {
                int result = SCANNER.nextInt();
                if (result > 0) {
                    return result;
                }
                System.out.println("입력 값은 0보다 커야 합니다.");
            } catch (InputMismatchException e) {
                System.out.println("입력 값은 0보다 큰 숫자여야 합니다. 입력값 = " + SCANNER.next());
            }
        }
    }
}
