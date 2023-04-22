package race.step4.view;

import race.step4.model.InputData;

import java.util.Scanner;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_TEXT_PLAYERS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_TEXT_NUM_TRY = "시도할 회수는 몇 회 인가요?";
    public static final String PLAYERS_DELIMITER = ",";

    public InputData inputData() {
        System.out.println(INPUT_TEXT_PLAYERS);
        String[] players = SCANNER.next().split(PLAYERS_DELIMITER);
        System.out.println(INPUT_TEXT_NUM_TRY);
        int numTry = SCANNER.nextInt();

        return new InputData(players, numTry);
    }
}
