package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    int number;
    int count;

    Car car;

    public Race() {}

    public Race(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public int getNumber() {
        return this.number;
    }

    public int getCount() {
        return this.count;
    }
}
