package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Winner> winnerList=new ArrayList<>();

    public Winners(Cars cars,int maxLocation){
        for (Car car : cars.getCars()) {
            if (car.getLocation() == maxLocation) {
                winnerList.add(new Winner(car.getCarName()));
            }
        }
    }

    public List<Winner> getWinners(){
        return winnerList;
    }

}
