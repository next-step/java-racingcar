package racingcar;

import java.util.Scanner;

public class InputView {

    public int inputCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        String joinedCar = scanner.nextLine();
        return toInt(joinedCar);
    }

    public int inputRaceCnt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        String raceCnt = scanner.nextLine();
        return toInt(raceCnt);
    }

    private static int toInt(String joinedCar) {
        return Integer.parseInt(joinedCar);
    }
}
