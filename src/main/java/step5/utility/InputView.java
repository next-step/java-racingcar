package step5.utility;

import step5.controller.UserInput;
import step5.model.Car;
import step5.model.Cars;

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
        String userInputForCarName = inputCarName();

        System.out.println(QUESTION_TRY_NUMBER);
        int tries = inputTries();

        System.out.println(RESULT);
        return new UserInput(userInputForCarName , tries);
    }


    private static String inputCarName() {
        Scanner sc = new Scanner(System.in);

        try {
            String input = sc.nextLine();
            return input;
        } catch (InputMismatchException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("정수만 입력가능합니다");
        }
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
