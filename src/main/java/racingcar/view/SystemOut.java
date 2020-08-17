package racingcar.view;

public class SystemOut implements OutputChannel {

    @Override
    public void printLine(String message) {
        System.out.println(message);
    }
}
