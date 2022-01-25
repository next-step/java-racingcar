package racingcar;

import java.util.Scanner;

public class UserInput {

    private final Printer printer = new Printer();
    private final Scanner scan = new Scanner(System.in);
    private final String[] carNames;
    private final Integer turn;

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

    private String getInputValue() {
        return scan.nextLine().trim();
    }

    private void validateCarName(String name) {
        checkIfValueIsNotEmpty(name);
        int NAME_LENGTH = 5;
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름이 %d자를 초과합니다.", NAME_LENGTH));
        }
    }

    private void validateTurn(String turn) {
        checkIfValueIsNotEmpty(turn);
        checkIfValueIsNumber(turn);
        checkIfValueGreaterThan1(turn);
    }

    private void checkIfValueIsNotEmpty(String line){
        if (line.equals(""))
            throw new IllegalArgumentException("값을 입력해주세요.");
    }

    private void checkIfValueIsNumber(String line){
        if (!line.matches("[+-]?\\d*(\\.\\d+)?"))
            throw new IllegalArgumentException("숫자를 입력해주세요.");
    }

    private void checkIfValueGreaterThan1(String line) {
        if (Integer.parseInt(line) < 1)
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
    }
}
