package racingcar;

import java.util.List;

public class RacingResult {
    public void executionResult(int tryCnt, List<RacingCar> racingCars) {
        for (int i = 0; i < tryCnt; i++)
            setRandomValue(racingCars);
    }

    public void setRandomValue(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            int value = racingCar.move(racingCar.createRandom());
            System.out.println(getRandomString(value));
        }
        System.out.println("\n");
    }

    public String getRandomString(int coord) {
        StringBuilder coordString = new StringBuilder();
        for (int i = 0; i < coord; i++)
            coordString.append("-");
        return coordString.toString();
    }
}
