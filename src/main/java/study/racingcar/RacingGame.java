package study.racingcar;

import java.util.List;

public class RacingGame {

    private static final int MOVE_CONDITION = 4;

    public static void gameStart(Game game) {

        ResultView.startGame();

        for(int i = 0; i < game.getNumberOfGames(); i++) {
            moveCar(game.getCarList());
        }
    }

    private static void moveCar(List<Car> cars) {

        for(Car car : cars) {
            if (isMove(GenerateNumber.random())) {
                move(car);
            }

            ResultView.resultGame(car.currentPosition());
        }

        ResultView.emptyLine();
    }

    public static void move(Car car) {

        car.setPosition(car.currentPosition() + 1);
    }

    private static boolean isMove(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }
}
