package racingcar;

import lombok.Data;

@Data
public class CarInfo {
    private int distance;
    private int resultOfRand;

    public CarInfo() {
        this.distance = 1;
    }

    public void moveFoward() {
        distance++;
    }
}
