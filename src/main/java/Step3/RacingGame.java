package Step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final List<RacingCar> cars;
    private final List<List<Integer>> gameRecord;
    private final int playNum;

    public RacingGame(int carNum, int playNum) {
        this.cars = new ArrayList<>();
        this.gameRecord = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            this.cars.add(new RacingCar());
        }

        this.playNum = playNum;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public List<List<Integer>> play() {
        Random random = new Random();
        for (int i = 0; i < this.playNum; i++) {
            List<Integer> turnRecord = tryMoveCars(random);

            this.gameRecord.add(turnRecord);
        }

        return this.gameRecord;
    }

    private List<Integer> tryMoveCars(Random random) {
        List<Integer> turnRecord = new ArrayList<>();

        for (RacingCar car : this.cars) {
            int position = car.move(random.nextInt(10));

            turnRecord.add(position);
        }

        return turnRecord;
    }
}
