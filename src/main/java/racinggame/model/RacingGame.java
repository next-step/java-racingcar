package racinggame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;


public class RacingGame {
    private List<Car> carList;
    private int raceTime;


    public RacingGame(String[] inputName, int raceTime) {
        this.raceTime = raceTime;
        this.carList = new ArrayList<>();

        Car car;
        for(int i = 0; i < inputName.length; i++) {
            car = new Car(inputName[i]);
            carList.add(car);
        }
    }

    /**
     * 레이싱 경기 1회 시도
     * @return
     */
    public List<Car> raceOneTime() {
        carList.forEach(car -> car.moveCar());
        reduceRaceTime();

        return carList;
    }

    /**
     * 레이싱 경기 시도시 경기횟수 1회 차감
     * @return
     */
    public int reduceRaceTime() {
        return raceTime--;
    }

    /**
     * 레이스 종료 여부 확인
     * @return
     */
    public boolean isRaceEnd() {
        return raceTime < 1;
    }


    /**
     * 레이싱 경기 우승자 가져오기
     * @return
     */
    public List<String> getWinner() {
        int maxPostion = getMaxPositon(carList).getAsInt();
        return carList.stream().filter(car -> car.getPosition() == maxPostion).map(Car::getName).collect(toList());
    }

    /**
     * 포지션 최대 값 가져오기
     * @param carList
     * @return
     */
    public OptionalInt getMaxPositon(List<Car> carList) {
        return carList.stream().mapToInt(Car::getPosition).max();
    }
}
