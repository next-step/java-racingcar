package car;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    int max = 0;
    List<Car> racingResult;
    List<Car> winnerCars;
    public RacingResult() {}

    public RacingResult(List<Car> cars) {
        this.racingResult = cars;
        winnerCars = new ArrayList<>();
        racingMaxPosition();
        winnerConfirm();
    }

    private void setMax(int carPosition) {
        if (carPosition >= this.max) {
            this.max = carPosition;
        }
    }
    public void racingMaxPosition() {
        for (Car car : this.racingResult) {
            setMax(car.getPosition());
        }
    }

    private void addWinnerCar(Car car){
        if(car.getPosition() == this.max){
            this.winnerCars.add(car);
        }
    }

    public void winnerConfirm(){
        for (Car car : this.racingResult) {
            addWinnerCar(car);
        }
    }

    public int getMax() {
        return this.max;
    }

    public List<Car> getWinnerCars(){
        return this.winnerCars;
    }
}