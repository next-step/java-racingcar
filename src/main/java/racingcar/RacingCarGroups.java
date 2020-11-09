package racingcar;

import java.util.List;

public class RacingCarGroups {
    private final List<RacingCar> racingCars;

    public RacingCarGroups(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void move() {
        for(int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).move();
        }
    }

    public void display() {
        for(int i = 0; i < racingCars.size(); i++) {
            racingCars.get(i).display();
        }
        System.out.println();
    }
}
