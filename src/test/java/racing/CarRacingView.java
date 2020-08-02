package racing;

import java.util.Arrays;
import java.util.Scanner;

public class CarRacingView {

    public static final char CAR_RACING_PRINT_SYMBOL = '-';

    private CarRacing carRacing;

    public void prepareCarRacing() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        carRacing = new CarRacing(carCount, tryCount);
    }

    public void startCarRacing() {
        if (carRacing == null) return;

        System.out.println(System.lineSeparator() + "실행 결과");

        carRacing.start(new CarRacingListener() {
            @Override
            public void carMoved(int movedDistance) {}

            @Override
            public void carMovedComplete(int totalDistance) {
                char[] array = new char[totalDistance];
                Arrays.fill(array, CAR_RACING_PRINT_SYMBOL);
                System.out.println(array);
            }

            @Override
            public void racingTriedComplete() {
                System.out.println();
            }
        });
    }

    public static void main(String[] args) {
        CarRacingView racingView = new CarRacingView();
        racingView.prepareCarRacing();
        racingView.startCarRacing();
    }
}
