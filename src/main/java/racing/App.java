package racing;

import java.util.List;
import java.util.Scanner;

import static racing.InputView.initializeGame;
import static racing.ResultView.printResult;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printResult(run(initializeGame(scanner)));
    }

    private static List<List<Integer>> run(RacingGame game) {
        return game.run();
    }
}
