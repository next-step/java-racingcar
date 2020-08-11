package racing.ui;

import racing.car.CarRacing;
import racing.car.MovableRule;
import racing.car.RandomMovableRule;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public CarRacing makeCarRacing() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        MovableRule movableRule = new RandomMovableRule();
        return new CarRacing(carNum, times, movableRule);
    }

}
