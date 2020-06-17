package step3;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();
    private Random distance = new Random();
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private void setRacingGame(int carCount) {
        for (int i = 0; i < carCount; i++){
            racingCars.add(new RacingCar());
        }
    }

    public boolean canMove() {
        return distance.nextInt(10) >= 4;
    }

    public List<RacingCar> playRacingGame() {
        for (RacingCar car: racingCars){
            if(canMove()) {
                car.move();
            }
        }
        return racingCars;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCars;
    }

    public void initRacingGame() {
        int carCount = inputView.numberOfCar();
        setRacingGame(carCount);
    }

    public void startRacingGame() {
        int gameCount = inputView.numberOfGame();
        for (int i = 0; i < gameCount; i++) {
            playRacingGame();
            getRacingGameResult();
        }
    }

    public void getRacingGameResult() {
        resultView.showResult(getRacingCarList());
    }

}
