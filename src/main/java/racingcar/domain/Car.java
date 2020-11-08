package racingcar;

import lombok.Getter;

import java.util.Random;

@Getter
public class Car {

    int distance;

    public Car() {
        distance = 0;
    }

    public int move(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
        return distance;
    }
}
