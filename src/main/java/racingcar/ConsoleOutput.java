package racingcar;

public class ConsoleOutput implements Output {
    @Override
    public void printOutput(final String outputMessage) {
        System.out.println(outputMessage);
    }
}
