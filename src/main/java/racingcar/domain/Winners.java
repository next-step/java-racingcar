package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winnerCars = new ArrayList<>();
    private int winnerPosition;

    public Winners(Cars cars) {
        winnerPosition = 0;
        getWinners(cars);
    }

    public String getWinnerNames(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<winnerCars.size()-1; i++){
            sb.append(winnerCars.get(i).getName()).append(", ");
        }
        sb.append(winnerCars.get(winnerCars.size()-1).getName());
        return sb.toString();
    }

    private void getWinners(Cars cars){
        getWinnerPosition(cars);
        for (Car car : cars.getCars()) {
            addWinner(car);
        }
    }

    private void getWinnerPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            isMoreThanTempWinnerPosition(car);
        }
    }

    private void isMoreThanTempWinnerPosition(Car car){
        if(car.isMoreThan(winnerPosition)){
            winnerPosition =  car.getPosition();
        }
    }

    private void addWinner(Car car) {
        if(car.isMoreThan(winnerPosition)){
            winnerCars.add(car);
        }
    }

}
