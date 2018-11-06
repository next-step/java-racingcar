package racinggame.model;

import java.util.ArrayList;
import java.util.List;

import static racinggame.util.RandomUtils.getRandom10;

public class RacingGame {
    private List<Car> cars;
    private int raceTime;


    public RacingGame(String[] inputName, int raceTime) {
        this.raceTime = raceTime;
        createCars(inputName);
    }

    /**
     * 레이싱 경기 1회 시도
     * @return
     */
    public List<Car> raceOneTime() {
        cars.forEach(car -> car.moveCar(getRandom10()));
        reduceRaceTime();

        return cars;
    }

    /**
     * 레이싱 경기 시도시 경기횟수 1회 차감
     * @return
     */
    public int reduceRaceTime() {
        return this.raceTime--;
    }

    /**
     * 레이스 종료 여부 확인
     * @return
     */
    public boolean isRaceEnd() {
        return this.raceTime < 1;
    }

    /**
     * 레이싱 참석 자동차 생성
     * @param inputName
     */
    public void createCars(String[] inputName) {
        this.cars = new ArrayList<>();

        for(int i = 0; i < inputName.length; i++) {
            Car car = new Car(inputName[i]);
            cars.add(car);
        }
    }
}
