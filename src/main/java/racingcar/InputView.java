package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    /**
     * 주어진 수 만큼 자동차를 만들어 리스트에 담아 리턴합니다.
     * @param amount
     * @return
     */
    public List<RacingCar> createRacingCars(int amount) {
        List<RacingCar> racingCars = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }
}
