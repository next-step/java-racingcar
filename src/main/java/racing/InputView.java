package racing;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_COUNT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";


    public static String[] inputCarNames(Scanner scanner) {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        String carNames = scanner.nextLine();
        if (carNames.length() == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] cars = carNames.split(",");
        for (String carName : cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할수 없습니다.");
            }
        }
        return cars;
    }

    public static int inputRacingCount(Scanner scanner) {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
