package racingcar.view;

import java.util.Scanner;

public class InputView {
    Integer carCount;
    Integer racingCount;

    public void insertCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        racingCount = scanner.nextInt();
    }
}
