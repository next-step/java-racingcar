package step4.domain;

import step4.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winners = new ArrayList<>();
    private final int maxStatus;

    public Winners(int maxStatus){
        this.maxStatus = maxStatus;
    }

    private boolean isWinner(Car car){
        return car.isWinner(maxStatus);
    }

    public void add(Car car){
        if(isWinner(car)){
            winners.add(car);
        }
    }

    public String getWinnerString(){
        StringBuilder str = new StringBuilder();
        str.append(winners.get(0).getOwner());

        int size = winners.size();
        for(int i = 1 ; i < size; i ++) {
            Car currentCar = winners.get(i);
            str.append(",").append(currentCar.getOwner());
        }

        return str.toString();
    }
}
