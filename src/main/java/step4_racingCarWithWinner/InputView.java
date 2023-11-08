package step4_racingCarWithWinner;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static String[] stringsSplitBy(String question, String delimiter){
        System.out.println(question);
        return scanner.nextLine().split(delimiter);
    }

    public static int intInput(String question){
        System.out.println(question);
        return scanner.nextInt();
    }
}
