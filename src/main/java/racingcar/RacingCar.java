package racingcar;

import java.util.Random;

class RacingCar {

    private final Random random = new Random();
    private String name;
    private int laps = 0;

    RacingCar() {
    }

    RacingCar(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int record() {
        return laps;
    }

    public void race() {
        int bound = 10;
        int benchmark = 4;
        if (random.nextInt(bound) >= benchmark) {
            laps++;
        }
    }
}
