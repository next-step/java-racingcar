package racing.carRacing.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String ASK_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";
    public static final String ASK_NUMBER_OF_STAGE = "시도할 회수는 몇 회 인가요?";

    public static String askNumberOfCar() {
        System.out.println(ASK_NUMBER_OF_CAR);
        return SCANNER.nextLine();
    }

    public static String askNumberOfStage() {
        System.out.println(ASK_NUMBER_OF_STAGE);
        return SCANNER.nextLine();
    }

}
