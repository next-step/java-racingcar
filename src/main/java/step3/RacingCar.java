package step3;

import java.util.Objects;
import java.util.Random;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;

    private RandomValue randomValue;

    private int distance = 0;
    private Name name;

    // 삭제예정
    public RacingCar() {
        this.randomValue = new RandomValue(new Random().nextInt(RANDOM_NUMBER_BOUND));
    }

    public RacingCar(Random random) {
        this.randomValue = new RandomValue(random.nextInt(RANDOM_NUMBER_BOUND));
    }

    public RacingCar(Random random, String name) {
        this(random);
        this.name = new Name(name);
    }

    // 삭제 예정
    public RacingCar(String name) {
        this();
        this.name = new Name(name);
    }

    public boolean isMove(RamdomCondition ramdomCondition) {
        return ramdomCondition.meet(this.randomValue);
    }

    public void move(RamdomCondition ramdomCondition) {
        if (isMove(ramdomCondition)) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof RacingCar)) {
            return false;
        }

        RacingCar racingCar = (RacingCar) obj;

        return Objects.equals(this.randomValue, racingCar.randomValue)
                && this.name.equals(racingCar.name)
                && this.distance == racingCar.distance;
    }

    @Override
    public int hashCode() {
        int hashCode = randomValue.hashCode();
        hashCode = 31 * hashCode + name.hashCode();
        hashCode = 31 * hashCode + Integer.hashCode(distance);

        return hashCode;
    }

}
