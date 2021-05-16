package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    static final int NAME_LENGTH = 5;
    static final int MOVE_NUMBER = 4;
    static final int MAX_RANDOM = 10;
    static final int WINNER_NUMBER = 0;
    static final String CAR_NAME_SPLIT = ",";
    static Random random = new Random();

    private List<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {

        List<Car> cars = getCars(getCarName(carNames));
        this.cars = cars;
        this.tryNo = tryNo;

    }

    private List<Car> getCars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public String[] getCarName(String carNamesStr) {
        String[] carNames = carNamesStr.split(CAR_NAME_SPLIT);
        for (String carName : carNames) {
            if (carName.length() > NAME_LENGTH) throw new IllegalArgumentException("이름은 5자 이내로 .");
        }
        return carNames;
    }


}
