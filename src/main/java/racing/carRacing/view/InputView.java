package racing.carRacing.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String ASK_NUMBER_OF_CAR = "자동차 대수는 몇 대 인가요?";

    public static String askNumberOfCar() {
        System.out.println(ASK_NUMBER_OF_CAR);
        return SCANNER.nextLine();
    }

}
