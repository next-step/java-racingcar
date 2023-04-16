package study.racingcar;

import java.util.List;

public class RacingGame {

    private List<Car> carList;
    private int numberOfGames;
    private static final int MOVE_CONDITION = 4;

    public RacingGame() {}

    public RacingGame(InputValue inputValue) {
        this.carList = SettingGame.createCars(inputValue);
        this.numberOfGames = inputValue.getNumberOfGames();
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
            if (isMove(GenerateNumber.random())) {
                move(car);
            }

            ResultView.resultGame(car);
        }

        ResultView.emptyLine();
    }

    public void move(Car car) {

        car.move(car.currentPosition());
    }

    private boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

}
