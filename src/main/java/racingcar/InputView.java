package racingcar;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    private String[] questions = new String[] {
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).",
            "시도할 회수는 몇 회 인가요?"
    };
    private String[] carNameList;
    private int carNumber;
    private int roundNumber;

    private static String ERR_NEGATIVE_NUMBER = "Negative numbers are not allowed.";
    private static String ERR_NAME_LENGTH = "Names longer than 5 characters are not allowed.";
    private static String NAME_DELIMITER = ",";

    public void input() {
        // car List
        System.out.println(questions[0]);
        carNameList = scanner.nextLine().split(NAME_DELIMITER);
        carNumber = carNameList.length;

        // round Number
        System.out.println(questions[1]);
        roundNumber = scanner.nextInt();

        validateInput();
    }

    public void validateInput() {
        validateCarNameList();
        validateRoundNumber();
    }

    private void validateCarNameList() {
        for (String name : this.carNameList) {
            validateCarName(name);
        }
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException(ERR_NAME_LENGTH);
        }
    }

    private void validateRoundNumber() {
        if (this.roundNumber < 0) {
            throw new RuntimeException(ERR_NEGATIVE_NUMBER);
        }
    }

    public int getCarNumber() {
        return this.carNumber;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }

    public String[] getCarNameList() {
        return this.carNameList;
    }
}
