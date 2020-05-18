package racingcar.race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private final List<Car> carList;
    private final RacingRule racingRule;
    private int raceTime = 0;

    public Racing(RacingRule racingRule, int carCount, int raceTime) {
        checkRacingCount(raceTime);

        this.raceTime = raceTime;
        this.racingRule = racingRule;
        this.carList = createCarList(carCount);
    }

    private List<Car> createCarList(int carCount) {
        List<Car> carListJoinRace = new ArrayList<>();
        for(int i = 0 ; i < carCount ; i++) {
            carListJoinRace.add(new Car());
        }
        return carListJoinRace;
    }

    public void start(GameResultReceiver receiver) {
        for(int i = 0 ; i < raceTime ; i++) {
            race();
            receiver.notifyFinishRace(getRaceResult());
        }
    }

    private void checkRacingCount(int racingCount) {
        if(racingCount <= 0) {
            throw new IllegalArgumentException("The number of racingCount must be at least 1.");
        }
    }

    private List<Integer> getRaceResult() {
        return carList.stream().map(Car::getPosition).collect(Collectors.toList());
    }

    private void race() {
        for(Car car : carList) {
            car.drive(racingRule.getMoveForward());
        }
    }

}
