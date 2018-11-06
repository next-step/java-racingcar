package racingcar.domain;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static String inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.next();
        return  cars;
    }

    public static int inputTryTime() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryTime = scanner.nextInt();
        return tryTime;
    }
}
