package racingcar;

public class ApplicationMain {
    public static void main(String[] args) {
        RacingGame
                .ready(new DefaultInput())
                .start()
                .result(new DefaultOutput());
    }
}
