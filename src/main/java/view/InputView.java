package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_CAR_CNT_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_CNT_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String DELIMITER = ",";
    private Scanner scanner = new Scanner(System.in);

    public void printCarCntInputText() {
        System.out.println(INPUT_CAR_CNT_TEXT);
    }

    public void printTryCntInputText() {
        System.out.println(INPUT_TRY_CNT_TEXT);
    }

    public Integer getUserInputToInteger() {
        return scanner.nextInt();
    }

    public List<String> getUserInputToStringList() {
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }
}
