package racingcar;

public class Main {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        OutputView outputView = new OutputView();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RacingCarApplication application = new RacingCarApplication(consoleReader, outputView, randomNumberGenerator);
        application.run();
    }
}
