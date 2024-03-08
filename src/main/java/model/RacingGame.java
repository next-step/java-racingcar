package model;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList;
    private final RacingRecord racingRecord;

    public RacingGame() {
        this.carList = new ArrayList<>();
        this.racingRecord = new RacingRecord();
    }

    public void participate(int count) {
        for (int i = 1; i <= count; i++) {
            this.carList.add(new Car());
        }
    }

    public void run() {
        for (Car car : carList) {
            int random = RandomUtil.randomNumber();
            car.move(random);
            racingRecord.record(car);
        }

        racingRecord.appendNewLine();
    }

    public String racingResult() {
        return racingRecord.toString();
    }

}
