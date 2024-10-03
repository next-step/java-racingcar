package step3RacingCarCompetition;

import java.util.ArrayList;
import java.util.List;

public class RacingCarInfo {

    private final List<Car> racingCarMovingData;

    public RacingCarInfo(int totalNumberOfCars, int totalMovingCount, RandomGenerator randomGenerator) {
        racingCarMovingData = new ArrayList<>();
        for (int numberOfCars = 0; numberOfCars < totalNumberOfCars; numberOfCars++) {
            Car car = new Car();// 새 인스턴스를 매번 생성 안해주면 랜덤값이 전부 같아지는 이슈 해결.
            car.recordCarData(totalMovingCount, randomGenerator);
            racingCarMovingData.add(car);
        }
    }

    public List<String> findEachRoundRacingCarData(int movingCount) {
        List<String> eachMovingCarData = new ArrayList<>();
        for (Car car : racingCarMovingData) {
            eachMovingCarData.add(car.findEachMovingData(movingCount));
        }
        return eachMovingCarData;
    }

}
