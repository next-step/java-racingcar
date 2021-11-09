package racingCar.ui;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분함)");
        String names = scanner.next();
        return names.split(",");
    }

    public int inputTryTimes() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
