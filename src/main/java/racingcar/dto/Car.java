package racingcar.dto;

import java.util.List;

public class Car {
    private String name;
    private List<Integer> state;

    public Car(String name) {
        this.name = name;
    }

    public Car(List<Integer> state) {
        this.state = state;
    }

    public Car(String name, List<Integer> state) {
        this.name = name;
        this.state = state;
    }

    public List<Integer> getState() {
        return this.state;
    }

    public String getName() {
        return this.name;
    }

}
