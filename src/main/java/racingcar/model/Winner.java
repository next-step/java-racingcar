package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Winner {
    private List<Car> cars ;
    public Winner(List<Car> car){
        this.cars= car;
    }
    public List<String> getWinner() {
        List<String> winnerList= new ArrayList<String>();
        int maxPosition= getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition().length() == maxPosition) {
                winnerList.add(car.getCarName());
            }
        }
        return winnerList;
    }
    public int getMaxPosition(){
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition().length() > maxPosition) {
                maxPosition = car.getPosition().length();

            }
        }
        return maxPosition;
    }
}
