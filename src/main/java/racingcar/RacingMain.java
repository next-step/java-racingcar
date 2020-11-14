package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame();
        
        List<Integer> input = inputView.inputRacing();
        racingGame.playRacing(input);
    }

}