package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winnerCars = new ArrayList<>();

    public Winners(Cars cars) {
        getWinners(cars);
    }

    public String getWinnerNames(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<winnerCars.size(); i++){
            sb.append(winnerCars.get(i).getName()).append(", ");
        }
        return sb.substring(0,sb.length()-2);
    }

    private void getWinners(Cars cars){
        CarPosition winnerPosition = getWinnerPosition(cars);
        for (Car car : cars.getCars()) {
            addWinner(car, winnerPosition);
        }
    }

    private CarPosition getWinnerPosition(Cars cars) {
        CarPosition winnerPosition = new CarPosition();
        for (Car car : cars.getCars()) {
            winnerPosition = car.getPosition().comparePosition(winnerPosition);
        }
        return winnerPosition;
    }

    private void addWinner(Car car, CarPosition winnerPosition) {
        if(car.isMoreThan(winnerPosition)){
            winnerCars.add(car);
        }
    }

}
