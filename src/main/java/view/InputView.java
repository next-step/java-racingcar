package view;

import CarRacing.CarRacing;
import CarRacing.Cars;

import java.util.Scanner;

public class InputView {


    private StringBuilder insertCarCountAndTryCount() {
        CarRacing carRacing;

        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");

        int carCount = scanner.nextInt();

        if (carCount < 1) {
            throw new IllegalArgumentException("자동차 개수는 0이하의 수를 허용하지 않습니다.");
        }

        System.out.println("시도할 회수는 몇 회 인가요?");

        int tryCount = scanner.nextInt();

        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 0이하의 수를 허용하지 않습니다.");
        }

        carRacing = new CarRacing(new Cars(carCount));

        return carRacing.moveCarsToString(tryCount);


    }

    public StringBuilder startInsertReturnStringBuilder() {
        return insertCarCountAndTryCount();
    }

}
