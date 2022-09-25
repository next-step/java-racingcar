package racingcar;

import java.util.Scanner;

public class InputView {

    public InputView() {
    }

    public int createCarNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        return carNum;
    }

    public int createTryTimes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryTimes = scanner.nextInt();
        return tryTimes;
    }
}
