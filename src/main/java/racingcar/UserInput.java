package racingcar;

import java.util.Scanner;

public class UserInput {

    static Printer printer = new Printer();
    static Scanner scan = new Scanner(System.in);
    static int NAME_LENGTH = 5;
    static String[] carNames;
    static Integer turn;

    public UserInput() {
        carNames = setCarNames();
        turn = setTurn();
    }

    private String[] setCarNames() {
        printer.printInputCarNameMessage();
        String[] names = getInputValue().split(",");
        try {
            for (int i = 0; i < names.length; i++) {
                String name = names[i].trim();
                validateCarName(name);
                names[i] = name;
            }
        } catch (IllegalArgumentException e) {
            printer.printErrorMessage(e.getMessage());
            return setCarNames();
        }
        return names;
    }

    public String[] getCarNames() {
        return carNames;
    }

    private int setTurn() {
        String count;
        try {
            printer.printInputTurnMessage();
            count = getInputValue();
            validateTurn(count);
        } catch (IllegalArgumentException e) {
            printer.printErrorMessage(e.getMessage());
            return setTurn();
        }
        return Integer.parseInt(count);
    }

    public int getTurn() {
        return turn;
    }

    public static String getInputValue() {
        return scan.nextLine().trim();
    }

    private static void validateCarName(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름이 %d자를 초과합니다.", NAME_LENGTH));
        }
    }

    private static void validateTurn(String turn) {
        if (turn.trim().equals("")) {
            throw new IllegalArgumentException("횟수를 입력해주세요.");
        } else if (!turn.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException("입력한 값은 숫자가 아닙니다.");
        } else if (Integer.parseInt(turn) < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
        }
    }
}
