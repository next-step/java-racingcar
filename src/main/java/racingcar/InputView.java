package racingcar;

import java.util.Scanner;

public class InputView {
    private Scanner sc = new Scanner(System.in);

    public int getNumberOfCar() {
        return sc.nextInt();
    }

    public int getCarMovingNum() {
        return sc.nextInt();
    }
}
