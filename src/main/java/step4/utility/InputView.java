package step4.utility;

import step4.controller.UserInput;
import step4.model.Car;
import step4.model.Cars;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은" +
            " 쉼표(,)를 기준으로 구분).";
    static final String QUESTION_TRY_NUMBER = "시도할 회수는 몇 회 인가요?";
    static final String RESULT = "\n실행 결과";

    private InputView() {
        throw new AssertionError("생성자 생성 불가!");
    }

    public static UserInput initShow() {
        System.out.println(QUESTION_CAR_NAME);
        Cars cars = inputCarName();

        System.out.println(QUESTION_TRY_NUMBER);
        int tries = inputTries();

        System.out.println(RESULT);
        return new UserInput(cars, tries);
    }


    private static Cars inputCarName() {
        Scanner sc = new Scanner(System.in);

        String input;
        String inputs[];
        Cars carName;

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

    private static Cars genName(String[] inputs) {
        List<Car> carName = new ArrayList<>();

        for (int i = 0; i < inputs.length; i++) {
            carName.add(new Car(inputs[i]));
        }
        Cars cars = new Cars(carName);

        return cars;
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
}
