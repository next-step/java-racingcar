package step3.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class InputView {

    private static final Scanner scan = new Scanner(System.in);
    private static final String CAR_NUMBER_CENTENCE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_NUMBER_CENTENCE = "시도할 횟수는 몇 회 인가요?";
    private static final String EXEPTION_WORDING = "잘못된 입력값 입니다.";
    private int inputValue;


    public int carNumberInput() {
        System.out.println(CAR_NUMBER_CENTENCE);
        input();
        return inputValue;
    }

    public int attemptNumberInput() {
        System.out.println(TRY_NUMBER_CENTENCE);
        input();
        return inputValue;
    }

    private int input() {

        inputValue = scan.nextInt();

        try {

            if(inputValue == 0) {
                throw new IllegalArgumentException(EXEPTION_WORDING);
            }


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        return inputValue;
    }

}
