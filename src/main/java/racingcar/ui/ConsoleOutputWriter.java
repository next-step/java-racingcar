package racingcar.ui;

public class ConsoleOutputWriter {

    private ConsoleOutputWriter() {

    }

    public static void write(ConsoleOutputMessage outputMessage) {
        System.out.println(outputMessage);
    }

}
