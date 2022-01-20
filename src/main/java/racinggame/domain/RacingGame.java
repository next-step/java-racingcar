package racinggame.domain;

import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {}

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.racingCars = racingCars;
        this.trial = trial;
    }

    public void start() {
        for (int i = 0; i < trial; i++) {
            progress();

            //TODO 계속 진행 묻기
            System.out.println("그만 하시려면 q, 계속하시려면 아무키나 입력해 주세요.");
        }
    }

    private void progress() {
        racingCars.forEach(car -> {
            int randomValue = getRandomValue();
            if (canForward(randomValue)) {
                car.forward();
            }
            car.printCurrPosition();
        });
    }

    public int getRandomValue() {
        int random = (int) Math.floor(Math.random() * (9 - 0 + 1));
        return random;
    }

    private boolean canForward(int randomValue) {
        return randomValue >= 4;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int getTrial() {
        return this.trial;
    }
}
