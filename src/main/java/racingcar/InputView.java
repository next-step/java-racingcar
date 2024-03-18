package racingcar;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int numberOfCar() {
        System.out.println("자동차 갯수를 입력하세요: ");
        return scanner.nextInt();
    }

    public int opportunity() {
        System.out.println("경주 진행 횟수를 입력하세요: ");
        return scanner.nextInt();
    }
}
