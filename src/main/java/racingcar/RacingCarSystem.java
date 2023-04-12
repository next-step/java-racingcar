package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarSystem {
    private List<RacingCar> racingCars;

    public void registerCar(int numberOfCar) {
        racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public int getRegisterNumberOfCar()
    {
        return racingCars.size();
    }
}
