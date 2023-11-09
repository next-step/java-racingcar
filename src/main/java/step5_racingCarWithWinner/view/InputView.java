package step5_racingCarWithWinner.view;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_QUESTION_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);
    public static String[] stringsSplitByComma(String question){
        System.out.println(question);
        return scanner.nextLine().split(CAR_NAME_QUESTION_DELIMITER);
    }

    public static int intInput(String question){
        System.out.println(question);
        return scanner.nextInt();
    }
}
