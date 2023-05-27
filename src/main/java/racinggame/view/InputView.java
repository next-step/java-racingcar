package racinggame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_QUESTION_FOR_A_NUM_OF_TRIAL = "시도할 회수는 몇 회 인가요?";

    public static String[] getCarNames() {
        System.out.println(ASK_QUESTION_FOR_CAR_NAMES);
        String[] carNames = SCANNER.nextLine().split(",");
        InputValidator.validateCarNamesLengthInRange(carNames);
        return carNames;
    }



    public static int getNumOfTrial() {
        System.out.println(ASK_QUESTION_FOR_A_NUM_OF_TRIAL);
        String numOfTrial = SCANNER.nextLine();
        InputValidator.validatePositive(numOfTrial);
        return Integer.parseInt(numOfTrial);
    }

}
