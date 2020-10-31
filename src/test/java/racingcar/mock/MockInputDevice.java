package racingcar.mock;

import racingcar.InputDevice;

public class MockInputDevice implements InputDevice {
    private final int number;

    public MockInputDevice(int number) {
        this.number = number;
    }

    @Override
    public int getIntNumber() {
        return number;
    }
}
