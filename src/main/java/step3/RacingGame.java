
package step3;

import java.util.List;

public class RacingGame {

    private Cars cars;

    public RacingGame(List<String> carNameList) {
        this.cars = new Cars(carNameList);
    }

    public void play() {
        cars.play();
    }

    public String getPlayResult(){
        return cars.getWayResult();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

}

