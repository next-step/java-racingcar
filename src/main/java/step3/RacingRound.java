package step3;

import step3.dto.Car;

import java.util.List;

public class RacingRound {

    public void playRound(List<Car> entryList) {
        for(Car car : entryList){
            goAndStopThisCar(car);
        }
    }

    private void goAndStopThisCar(Car car) {
        if(MoveCar.moveCondition()) return;

        car.movePosition();
    }
}
