package racingcar;

import java.util.Scanner;

public class InputView {
    public static int numberOfCar(){
        System.out.println("자동차 갯수를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int opportunity(){
        System.out.println("경주 진행 횟수를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
