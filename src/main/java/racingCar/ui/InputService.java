package racingCar.ui;

import java.util.Scanner;

public class InputService {

    private InputService() {

    }

    static Scanner scanner = new Scanner(System.in);

    static public int getNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    static public int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    static public String getCarNameString() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

}
