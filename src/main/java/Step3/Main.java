package Step3;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        int carNum = inputView.readInput("자동차 대수는 몇 대 인가요?");
        int playNum = inputView.readInput("시도할 횟수는 몇 회 인가요?");

        List<List<Integer>> gameRecord = new RacingGame(carNum, playNum).play();

        inputView.printResult(gameRecord);
    }
}
