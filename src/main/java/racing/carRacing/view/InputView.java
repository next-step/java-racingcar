package racing.carRacing.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String DELIMITER = ",";
    public static final String ASK_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String ASK_NUMBER_OF_STAGE = "시도할 회수는 몇 회 인가요?";

    public static String[] askCarsName() {
        System.out.println(ASK_CARS_NAME);
        return SCANNER.nextLine().split(DELIMITER);
    }

    public static int askNumberOfStage() {
        System.out.println(ASK_NUMBER_OF_STAGE);
        return SCANNER.nextInt();
    }

}
