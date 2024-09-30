package racing.car.game;

import racing.car.util.NumberUtil;

public class RacingCalculator {

    /**
     * 값이 4 이상이면 1 4미만이면 0을 반환
     * */
    public static int goAndStop(int number) {
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
            int randomNumber = goAndStop(NumberUtil.randomInt(0, 9));
            cars[i] = cars[i] + randomNumber;
        }
        return cars;
    }
}
