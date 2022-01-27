package racingcar;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();

        RacingCarGame racingCarGame = new RacingCarGame(console.getTryCount(),
            console.getCarNames());

        racingCarGame.play();
    }
}
