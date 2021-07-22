package racingcar;

import java.util.Scanner;

/*
 * 자동차 경주 Input
 */
public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
