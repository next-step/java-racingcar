package racingcar;

import java.security.InvalidParameterException;

import static racingcar.RacingRandom.LIMIT;

public class RandomNo {

    private final int number;

    public RandomNo(int number) {
        if(number > LIMIT || number < 0){
            throw new InvalidParameterException("유효한 숫자가 아닙니다.");
        }
        this.number = number;
    }

    public boolean isEqualOrOver(int num) {
        return number >= num;
    }
}
