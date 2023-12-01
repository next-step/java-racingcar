package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private List<Car> racingResult;

    public RacingResult(Cars cars) {
        this.racingResult = cars.getCarList();
    }

    public int getMaxForward(){
        int maxForward = 0;
        for(Car car : racingResult){
            maxForward = car.returnMaxCount(maxForward);
        }

        return maxForward;
    }

    public List<String> returnWinnerCar() {
        List<String> winners = new ArrayList<>();
        int maxForward = getMaxForward();
        for(Car car : racingResult){
            car.addMaxForwardCar(maxForward, winners);
        }

        return winners;
    }
}
