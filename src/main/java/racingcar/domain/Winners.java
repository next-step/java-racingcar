package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winnerCars = new ArrayList<>();
    private int winnerPosition;

    public Winners(Cars cars) {
        winnerPosition = cars.getWinnerPosition();
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
        for (Car car : cars.getCars()) {
            addWinner(car);
        }
    }

    private void addWinner(Car car) {
        if(car.isMoreThan(winnerPosition)){
            winnerCars.add(car);
        }
    }

}
