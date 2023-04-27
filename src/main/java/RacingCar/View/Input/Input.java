package RacingCar.View.Input;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);
    static String WHAT_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    static String HOW_COUNT_CAR = "시도할 회수는 몇 회 인가요?";

    public String[] splitCarName(String split) {
        System.out.println(WHAT_CARS_NAME);

        String[] result = scanner.next().split(split);

        return result;
    }


    public int InputTryCount() {
        System.out.println(HOW_COUNT_CAR);

        return scanner.nextInt();
    }
}
