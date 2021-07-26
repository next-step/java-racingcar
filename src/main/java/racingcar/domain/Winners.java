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
        for (Car car : cars.getCars()) {
            addWinner(car, cars.getWinnerPosition());
        }
    }

    private void addWinner(Car car, int winnerPosition) {
        if(car.isMoreThan(winnerPosition)){
            winnerCars.add(car);
        }
    }

}
