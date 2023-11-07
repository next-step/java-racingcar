package study;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarValue(){

        System.out.println("자동차 대수는 몇 대 인가요?");
        return SCANNER.nextLine();
    }


    public static String inputStepValue(){

        System.out.println("시도할 회수는 몇 회 인가요?");
        return SCANNER.nextLine();
    }
}
