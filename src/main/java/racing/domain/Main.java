package racing.domain;

import racing.view.Input;
import racing.view.Output;

public class Main {
    public static void main(String[] args) {
        final String carNameInput = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        final String attemptsNumberInput = "시도할 횟수는 몇 회 인가요?";

        Game game = new Game();
        Input input = new Input();

        game.createAttendedCarsWithName(input.askStringInput(carNameInput));
        game.playGame(input.askIntInput(attemptsNumberInput));
        input.close();
        Output.showWinner(game.getWinners());
    }
}
