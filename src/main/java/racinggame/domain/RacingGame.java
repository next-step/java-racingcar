package racinggame.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {}

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.racingCars = racingCars;
        this.trial = trial;
    }

    public void start() throws IOException {
        for (int i = 0; i < trial; i++) {
            progress();

            String input = getCommand();
            if(isEnd(input)){
                System.exit(0);
            }
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

    private boolean canForward(int randomValue) {
        return randomValue >= 4;
    }

    private String getCommand() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("그만 하시려면 q, 계속하시려면 아무키나 입력해 주세요.");
        return br.readLine();
    }

    private boolean isEnd(String input) {
        return input.equals("q");
    }

    public int getRandomValue() {
        int random = (int) Math.floor(Math.random() * (9 - 0 + 1));
        return random;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int getTrial() {
        return this.trial;
    }
}
