package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RacingGame {

    private static Random random = new Random();
    private static List<Car> cars = new ArrayList();
    private FinalResult finalResult = new FinalResult();
    private int countRound = 0;
    private int thisRound = 0;

    public void setPlusCountRound(int addCountRound) {
        this.countRound += addCountRound;
    }

    public List<Car> preparedRacingCars() {
        return cars;
    }

    public int getNumber() {
        return random.nextInt(10);
    }

    public void playRacing() {
        EachRound eachRound = new EachRound();
        int carName = 0;

        for (Car car : cars) {
            carName++;
            car.updateByCondition(getNumber());
            eachRound.recordRoundPosition(car, "차이름 : " + carName);
        }

        finalResult.recordRoundPosition(thisRound, eachRound.getResult());
        thisRound++;
    }

    public boolean hasNextRound() {
        return countRound > thisRound;
    }

    public Map<Integer, Map<String, Integer>> startRacing() {
        while (hasNextRound()) {
            playRacing();
        }

        return finalResult.getFinalResult();
    }

    public void initRacing(int countCar, int countRound) {
        for (int i = 0; i < countCar; i++) {
            cars.add(new Car(0));
        }

        this.countRound = countRound;
    }
}
