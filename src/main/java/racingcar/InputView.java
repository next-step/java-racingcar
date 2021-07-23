package racingcar;

import java.util.Scanner;

/*
 * 자동차 경주 Input
 */
public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    public String[] insertCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요");
        return splitCarName(sc.nextLine());
    }

    public String[] splitCarName(String text) {
        if (!text.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 ','로 구분되어야 합니다.");
        }
        return createNameOfCarsArray(text);
    }

    private String[] createNameOfCarsArray(String text) {
        String[] cars = text.split(",");
        for (int i = 0; i < cars.length; i++) {
            carLengthValidate(cars[i]);
        }
        return text.split(",");
    }

    private void carLengthValidate(String car) {
        if (car.length() > LIMIT_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자가 최대입니다.");
        }
    }


    public int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
