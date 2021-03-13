package new_racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_MESSAGE = "참가 선수를 입력해주세요";
    private static final String INPUT_TURN_MESSAGE = "진행 횟수를 입력해주세요";

    public int setPlayer() {
        int playerConut = 0;
        while (!isValid(playerConut)) {
            playerConut = inputNumber(INPUT_PLAYER_MESSAGE);
        }
        return playerConut;
    }

    public boolean isValid(int playerCont) {
        return (playerCont > 0);
    }

    public int inputNumber(String msg) {
        int result = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(msg);
            result = scanner.nextInt();
        } catch (Exception e) {
            printInputError();
        }

        return result;
    }

    public int setTurn() {
        int turnCount = 0;
        while (!isValid(turnCount)) {
            turnCount = inputNumber(INPUT_TURN_MESSAGE);
        }
        return turnCount;
    }

    private void printInputError() {
        System.out.println("잘못 입력하셨습니다");
    }
}
