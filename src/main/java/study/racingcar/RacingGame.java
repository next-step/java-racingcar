package study.racingcar;

import java.util.List;

public class RacingGame {

    private List<Car> carList;
    private int numberOfGames;

    public RacingGame(RacingGameInputs racingGameInputs) {
        this.carList = SettingGame.createCars(racingGameInputs);
        this.numberOfGames = racingGameInputs.getNumberOfGames();
    }

    public void gameStart() {

        ResultView.startGame();

        int lastLapCheck = 0;

        while(!isOver(numberOfGames, lastLapCheck)){
            moveCar(carList);

            lastLapCheck++;
        }

        ResultView.winner(new GameWinner(carList).findGameWinner());
    }

    private boolean isOver(int numberOfGames, int lastLapCheck) {

        return numberOfGames <= lastLapCheck;
    }

    private void moveCar(List<Car> cars) {

        for(Car car : cars) {

            car.move(GenerateNumber.random());

            ResultView.resultGame(car);
        }

        ResultView.emptyLine();
    }
}
