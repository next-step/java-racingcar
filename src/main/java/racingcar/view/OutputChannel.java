package racingcar.view;

public interface OutputChannel {

    static OutputChannel createSystemOut() {
        return new SystemOut();
    }
    void printLine(String message);
}
