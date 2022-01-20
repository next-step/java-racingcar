package racingcar;

public class ApplicationRacingCar {
    public static void main(String[] args) {
        Console console = new Console();

        RacingCarGame racingCarGame = new RacingCarGame(console.getTryCount(),
            console.getCarNames());

        racingCarGame.playRacingCarGame();
    }
}
