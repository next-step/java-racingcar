package racingCar.step4;

import java.util.Objects;
import java.util.Random;

public class RandomNumber {

    private static final int NUMBER_LIMIT = 10;
    private static final Random RANDOM = new Random();
    private int number;

    public RandomNumber() {}

    public RandomNumber(int number) {
        this.number = number;
    }

    public int generate(){
        if(number == 0){
            return RANDOM.nextInt(NUMBER_LIMIT);
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomNumber that = (RandomNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
