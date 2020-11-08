package racingcar.domain;

import lombok.Getter;

@Getter
public class Car {

    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int move(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
        return distance;
    }
}
