package study.racingcar;

public class RacingCar {

    public static void main(String[] args) {
        racingCar();
    }

    public static void racingCar () {

        String carNamesStr = InputView.setCarNames();
        int numberOfGames = InputView.setGames();

        new RacingGame(new InputValue(numberOfGames, carNamesStr)).gameStart();
    }
}
