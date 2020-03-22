package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class RacingGame {

    // 각 Car들의 시작 위치
    public static final int BASE_POSITION = 1;

    // 랜덤값이 해당 값 이상일때만 move
    private static final int MORE_THAN_VALUE_FOR_CAR_MOVE = 4;

    private ArrayList<Integer> carPositions;
    private RandomValueGeneratable randomValueGenerator;

    public RacingGame(int carTotalCount) {
        this(carTotalCount, getRandomValueGenerator());
    }

    public RacingGame(int carTotalCount, RandomValueGeneratable randomValueGenerator) {
        validateInputCount(carTotalCount);
        initCarPositions(carTotalCount);
        this.randomValueGenerator = randomValueGenerator;
    }

    public void startRacing(int runCount) {
        validateInputCount(runCount);
        for (int i = 0; i < runCount; i++) {
            moveCar();
        }
    }

    public ArrayList<Integer> getCurrentCarPositions() {
        ArrayList<Integer> cloneCarPositoins = (ArrayList<Integer>) this.carPositions.clone();
        return cloneCarPositoins;
    }

    private void moveCar() {
        for (int i = 0; i < this.carPositions.size(); i++) {
            if (randomValueGenerator.getRandomValue() > MORE_THAN_VALUE_FOR_CAR_MOVE) {
                this.carPositions.set(i, this.carPositions.get(i) + 1);
            }
            printCarPositions(i);
        }
    }

    private void printCarPositions(int carPosition) {
        for (int i = 0; i < this.carPositions.get(carPosition); i++) {
            System.out.print("-");
        }
        System.out.println();

        if (carPosition == this.carPositions.size() - 1) {
            System.out.println();
        }
    }

    private void initCarPositions(int carTotalCount) {
        this.carPositions = new ArrayList<>();
        for (int i = 0; i < carTotalCount; i++) {
            this.carPositions.add(BASE_POSITION);
        }
    }

    private void validateInputCount(int inputCount) {
        if (inputCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해야 합니다.");
        }
    }

    private static RandomValueGeneratable getRandomValueGenerator() {
        RandomValueGeneratable randomValueGeneratable = () -> {
            Random random = new Random();
            return random.nextInt(10);
        };
        return randomValueGeneratable;
    }
}
