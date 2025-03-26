package racingcar;

public class Main {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();
        NumberBasedCarMover carMover = new RandomNumberBasedCarMover();
        racingCarGame.startGame(carMover);
    }
}
