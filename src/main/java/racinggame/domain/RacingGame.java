package racinggame.domain;

import racinggame.dto.SnapShotDto;
import racinggame.random.CapacityGenerator;

public class RacingGame {

    private Cars cars;
    private Integer repeatCount;

    public RacingGame(int repeatCount,int carCount) {
        this.repeatCount=repeatCount;
        this.cars = Cars.from(carCount);
    }


    public SnapShotDto start(CapacityGenerator capacityGenerator) {
        for(int i=0;i<repeatCount;i++){
            cars.move(capacityGenerator);
        }
        return cars.history();
    }

}
