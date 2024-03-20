package racing;

import racing.controller.GameController;
import racing.view.Input;
import racing.view.Output;

public class Main {
    public static void main(String[] args) {
        final String carNameInput = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        final String attemptsNumberInput = "시도할 횟수는 몇 회 인가요?";

        Input input = new Input();

        Output.showWinner(GameController.playGame(
                GameController.createGame(input.inputCarNames(carNameInput)),
                input.inputAttempts(attemptsNumberInput)
        ).getWinners());

        input.close();
    }
}
