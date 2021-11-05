package racingcar.step3.view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public int countOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public int countOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }

}
