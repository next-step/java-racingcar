package racingcar.view;

import java.util.Scanner;

public class InputView {

    public int createCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int putCoins() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
