package step2;

import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPositions;

    public void doGame() {
        ResultView resultView = new ResultView();

        setGameData();
        resultView.printResultTitle();

        for (int i = 0; i < time; i++) {
            move();
            resultView.printCars(carPositions);
        }
    }

    private void setGameData() {
        InputView inputView = new InputView();
        this.time = inputView.getTrialNum();
        this.carPositions = new int[inputView.getCarNum()];
    }

    private int[] move() {
        for (int i = 0; i < this.carPositions.length; i++) {
            if(getRandom() > 3){
                this.carPositions[i]++;
            }
        }
        return carPositions;
    }

    private int getRandom(){
        Random random = new Random();
        return random.nextInt(10);
    }

}
