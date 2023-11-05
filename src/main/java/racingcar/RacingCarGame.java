package racingcar;

import racingcar.ui.InputView;

public class RacingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        gameStart(inputView.inputCarNumber(), inputView.inputGameTurn());

    }

    private static void gameStart(int carNumber, int gameTurn) {
        System.out.println("게임 시작");


    }
}