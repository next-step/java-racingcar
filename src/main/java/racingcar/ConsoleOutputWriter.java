package racingcar;

public class ConsoleOutputWriter {

    private ConsoleOutputWriter() {

    }

    public void write(ConsoleOutputMessage outputMessage) {
        System.out.println(outputMessage);
    }

}
