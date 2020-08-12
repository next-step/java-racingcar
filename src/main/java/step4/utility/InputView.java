package step4.utility;

import step4.controller.UserInput;
import step4.model.Car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은" +
            " 쉼표(,)를 기준으로 구분).";
    static final String QUESTION_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    static final String RESULT = "\n실행 결과";

    public static UserInput initShow() {
        System.out.println(QUESTION_CAR_NAME);
        Car[] cars = inputCarName();

        System.out.println(QUESTION_TRY_NUMBER);
        int tries = inputTries();

        System.out.println(RESULT);
        return new UserInput(cars, tries);
    }

    private static int inputTries() {
        Scanner sc = new Scanner(System.in);

        try {
            int input = sc.nextInt();
            return input;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("정수만 가능합니다");
        }
    }

    private static Car[] inputCarName() {
        Scanner sc = new Scanner(System.in);

        String input;
        String inputs[];
        Car carName[];

        try {
            input = sc.nextLine();
            inputs = input.split(",");
            carName = genName(inputs);

            return carName;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("정수만 입력가능합니다");
        }
    }

    private static Car[] genName(String[] inputs) {
        int length = inputs.length;

        Car[] carName = new Car[length];

        for (int i = 0; i < length; i++) {
            carName[i] = new Car(inputs[i]);
        }
        return carName;
    }
}
