package racingcar.view;

import racingcar.domain.Race;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Race inputRace() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = 0;
        try {
            carCount = scanner.nextInt();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = 0;
        try {
            tryCount = scanner.nextInt();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        System.out.println();
        return new Race(carCount, tryCount);
    }
}
