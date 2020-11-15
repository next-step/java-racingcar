package racing.domain;

import racing.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String POSITION = "-";
    public static final String CONNECT_CHAR = " : ";

    private static Cars cars;
    private static int repeat;

    public RacingGame(String nameOfCars, int repeat) {
        this.cars = Cars.from(nameOfCars);
        this.repeat = repeat;
    }

    public List<String> run() {
        List<String> listMsg = new ArrayList<String>();
        for (int i = 0; i < repeat; i++) {
            cars.nextRound();
            cars.getCarList().forEach(car ->
                    listMsg.add(car.getName() + CONNECT_CHAR + StringUtils.repeat(POSITION, car.getPosition())));
            listMsg.add("");
        }
        return listMsg;
    }

    public Cars getCars() {
        return cars;
    }
}
