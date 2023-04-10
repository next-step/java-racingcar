package racingcar;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RacingInfo {
    private int numOfCars;
    private int numOfTries;
    private ArrayList<Car> cars;
}
