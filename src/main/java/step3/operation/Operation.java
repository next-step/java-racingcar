package step3.operation;

import step3.view.ResultView;

import java.util.Random;

public class Operation {

    static ResultView resultView = new ResultView();
    public static final int STANDARD_NUMBER = 4;

    public static void gameStart(int numOfAtp, int numOfCars) {
        resultView.viewProgress(numOfAtp, numOfCars);
    }


    public void progress(int[] game, int[] result) {
        for(int w = 0 ; w < game.length; w++) {
            game[w] = decideToMove(result[w], game[w]);
            resultView.showToMove(game[w]);
        }
    }

    public int decideToMove(int result, int game) {
        if(result >= STANDARD_NUMBER) {
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
