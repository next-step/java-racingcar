package racingcar.view;

import java.util.Scanner;

public class InputView {

    final Scanner sc = new Scanner(System.in);

    public int askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }
}
