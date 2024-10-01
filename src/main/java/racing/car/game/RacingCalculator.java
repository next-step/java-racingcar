package racing.car.game;

import racing.car.util.NumberUtil;

public class RacingCalculator {

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    /**
     * 값이 4 이상이면 1 4미만이면 0을 반환
     * */
    public static int goAndStop(int number) {
        if (number < MIN_BOUND || number > MAX_BOUND) {
            throw new IllegalArgumentException();
        }

        if (number >= 4) {
            return 1;
        }
        return 0;
    }

    /**
     * 랜덤 값을 자동차 배열에 넣는 기능
     * */
    public static int[] carToArrayRandomValues(int[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int randomNumber = goAndStop(NumberUtil.randomInt(MIN_BOUND, MAX_BOUND));
            cars[i] = cars[i] + randomNumber;
        }
        return cars;
    }
}
