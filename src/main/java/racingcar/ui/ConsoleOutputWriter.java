package racingcar.ui;

public class ConsoleOutputWriter {

    private ConsoleOutputWriter() {

    }

    public void write(ConsoleOutputMessage outputMessage) {
        System.out.println(outputMessage);
    }

}
