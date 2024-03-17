package race.domain;

import race.util.RandomUtil;

import java.util.List;

public class RacingGame {

    public List<Car> race(List<Car> carList) {
        RandomUtil randomUtil = new RandomUtil();

        for (int i = 0; i < carList.size(); i++) {
            int random = randomUtil.randomNum();
            carList.get(i).makeForward(random);
        }

        return carList;
    }
}
