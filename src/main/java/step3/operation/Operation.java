package step3.operation;

import step3.view.InputView;
import step3.view.ResultView;

import java.util.Random;

public class Operation {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        gameStart(inputView.numberOfAttempts("5"), inputView.numOfCars("3"));
    }

    public static void gameStart(int numOfAtp, int numOfCars) {
        ResultView resultView = new ResultView();
        resultView.viewProgress(numOfAtp, numOfCars);
    }

    public void progress(int[] game, int[] result) {
        ResultView resultView = new ResultView();
        for(int w = 0 ; w < game.length; w++) {
            game[w] = decideToMove(result[w], game[w]);
            resultView.showToMove(game[w]);
        }
    }

    public int decideToMove(int result, int game) {
        if(result >= 4) {
            return game + 1;
        }
        return game;
    }

    public int[] makeRandomValue(int numOfCars) {
        Random random = new Random();
        int[] randomValue = new int[numOfCars];
        for(int i = 0; i < randomValue.length; i++) {
            randomValue[i] = random.nextInt(10);
        }
        return randomValue;
    }
}
