package racingcar.mock;

import racingcar.view.inputview.InputDevice;

public class MockInputDevice implements InputDevice {
    private final String string;
    private final int number;

    public MockInputDevice(String string, int number) {
        this.string = string;
        this.number = number;
    }

    @Override
    public int getIntNumber() {
        return number;
    }

    @Override
    public String getString() {
        return string;
    }
}
