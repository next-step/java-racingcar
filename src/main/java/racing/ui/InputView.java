package racing.ui;

import racing.car.CarRacing;
import racing.car.MovableRule;
import racing.car.RandomMovableRule;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public CarRacing makeCarRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분)");
        String inputNames = scanner.nextLine();
        String[] names = inputNames.split(",");

        System.out.println("시도할 회수는 몇 회 인가요?");
        int times = scanner.nextInt();

        MovableRule movableRule = new RandomMovableRule();
        return new CarRacing(names, times, movableRule);
    }

}
