package racingcar;

public class ApplicationMain {

    private static final Input INPUT = new DefaultInput();
    private static final Output OUTPUT = new DefaultOutput();

    public static void main(String[] args) {
        ready(INPUT, OUTPUT)
                .start()
                .result(OUTPUT);
    }

    private static RacingGame ready(Input input, Output output) {
        try {
            return RacingGame.ready(input);
        } catch (NotPositiveNumberException e) {
            output.printMessage(e.getMessage());
            return ready(input, output);
        }
    }

}
