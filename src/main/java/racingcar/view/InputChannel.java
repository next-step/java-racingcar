package racingcar.view;

public interface InputChannel {
    static InputChannel createSystemIn() {
        return new SystemIn();
    }

    int getIntValue();

    String getStringValue();
}
