package racingCar.ui;

import java.util.Scanner;

public class InputService {

    private InputService() {

    }

    static Scanner scanner = new Scanner(System.in);

    static public int getNumberOfCar(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    static public int getTryCount(){
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
