package step4;

import static step4.ErrorMessages.DUPLICATED_CAR_NAMES_MESSAGE;
import static step4.ErrorMessages.INVALID_CAR_NAMES_MESSAGE;
import static step4.ErrorMessages.INVALID_TRY_COUNT_MESSAGE;

import java.util.Objects;
import java.util.Random;

public class RacingGame {
    private Random random;
    private String[] names;
    private int tryCount;
    private int[] carPositions;
    private String[] winners;

    public String[] getNames() {
        return this.names;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public String[] getWinners() {
        return this.winners;
    }

    public int[] getCarPositions() {
        return this.carPositions;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Random getRandom() {
        return random;
    }

    public RacingGame() {
        this.random = new Random();
    }

    public void goCar() {
        if (this.random == null) {
            this.random = new Random();
        }
        for(int i = 0; i < this.carPositions.length; ++i) {
            if (this.random.nextInt() >= 4) {
                this.carPositions[i]++;
            }
        }
    }

    public void initialize(String names, int tryCount) throws IllegalArgumentException {
        validateCarNames(names);
        validateTryCount(tryCount);

        this.names = parseCarNames(names);
        this.carPositions = new int[this.names.length];
        this.tryCount = tryCount;
    }

    public void validateCarNames(String names) throws IllegalArgumentException {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }
        String[] parsedParameter = parseCarNames(names);
        validateDuplicatedCarNames(parsedParameter);
        if (parsedParameter.length < 2) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }

    }

    public void validateDuplicatedCarNames(String[] names) throws IllegalArgumentException {
        DistinctNameSet distinctNameSet = new DistinctNameSet();
        for (String name : names) {
            distinctNameSet.assertDistinctName(name, DUPLICATED_CAR_NAMES_MESSAGE);
        }
    }

    public String[] parseCarNames(String names) {
        return names.split(Constants.COMMA);
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < 1 || tryCount > 10) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }
}
