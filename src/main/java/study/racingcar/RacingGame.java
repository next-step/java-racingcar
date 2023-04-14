package study.racingcar;

import java.util.List;

public class RacingGame {

    private final List<Car> carList;
    private final int numberOfGames;
    private static final int MOVE_CONDITION = 4;

    public RacingGame() {
        this.carList = SettingGame.createCars(InputView.setCars());
        this.numberOfGames = InputView.setGames();
    }

    public void gameStart() {

        ResultView.startGame();

        int lastLapCheck = 0;

        while(!isOver(numberOfGames, lastLapCheck)){
            moveCar(carList);

            lastLapCheck++;
        }
    }

    private boolean isOver(int numberOfGames, int lastLapCheck) {

        return numberOfGames <= lastLapCheck;
    }

    private void moveCar(List<Car> cars) {

        for(Car car : cars) {
            if (isMove(GenerateNumber.random())) {
                move(car);
            }

            ResultView.resultGame(car.currentPosition());
        }

        ResultView.emptyLine();
    }

    public void move(Car car) {

        car.setPosition(car.currentPosition() + 1);
    }

    private boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }
}
