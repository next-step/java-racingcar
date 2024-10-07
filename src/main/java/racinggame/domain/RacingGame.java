package racinggame.domain;

import racinggame.dto.SnapShotDto;
import racinggame.random.Radom;

public class RacingGame {

    private Cars cars;
    private Integer repeatCount;

    public RacingGame(int repeatCount,int carCount) {
        this.repeatCount=repeatCount;
        this.cars = Cars.of(carCount);
    }


    public SnapShotDto start(Radom radom) {
        for(int i=0;i<repeatCount;i++){
            cars.move(radom);
        }
        return cars.history();
    }

}
