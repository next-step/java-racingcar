package study.racingcar;

import java.util.Scanner;

public class InputView {
    public static RacingGameData getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String numberOfCar = scanner.next();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int time = scanner.nextInt();

        return new RacingGameData(numberOfCar.split(","), time);
    }
}
