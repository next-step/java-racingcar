package racing.ui;

import racing.domain.Car;

import java.util.Scanner;

public class InputView {

    static Scanner SCANNER = new Scanner(System.in);

    static String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    static String CAR_COUNT = "자동차 대수는 몇 대 인가요?";

    public Car showView() {
        int carCount = carCount();
        int tryCount = tryCount();

        return new Car(carCount, tryCount);
    }


    private static int tryCount() {
        System.out.println(TRY_COUNT);
        return SCANNER.nextInt();
    }

    private static int carCount() {
        System.out.println(CAR_COUNT);
        return SCANNER.nextInt();
    }

}
