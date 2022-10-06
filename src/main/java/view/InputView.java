package view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_CNT_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_CNT_TEXT = "시도할 회수는 몇 회 인가요?";

    Scanner scanner = new Scanner(System.in);

    public void printCarCntInputText() {
        System.out.println(INPUT_CAR_CNT_TEXT);
    }

    public void printTryCntInputText() {
        System.out.println(INPUT_TRY_CNT_TEXT);
    }

    public Integer getUserInputToInteger() {
        return scanner.nextInt();
    }
}
