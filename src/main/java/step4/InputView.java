package step4;

import java.util.Scanner;

public class InputView {
    private static final String HOW_MANY_CAR = "자동차의 대수는 몇 대 인가요?";
    private static final String HOW_MANY_CYCLE = "시도할 횟수는 몇 회 인가요?";
    private Scanner sc = new Scanner(System.in);

    public int getNumOfCar() {
        System.out.println(HOW_MANY_CAR);
        return getInput();
    }

    public int getNumOfCycle() {
        System.out.println(HOW_MANY_CYCLE);
        return getInput();
    }

    private int getInput() {
        return sc.nextInt();
    }
}
