package racinggame.domain;

import racinggame.dto.History;
import racinggame.random.CapacityGenerator;

public class RacingGame {

    private Cars cars;
    private Integer repeatCount;

    public RacingGame(int repeatCount,int carCount) {
        if(repeatCount<=0){
            throw new IllegalArgumentException("반복횟수는 1이상이여야 합니다.");
        }
        this.repeatCount=repeatCount;
        this.cars = Cars.from(carCount);
    }

    public History start(CapacityGenerator capacityGenerator) {
        for(int i=0;i<repeatCount;i++){
            cars.move(capacityGenerator);
        }
        return cars.history();
    }

}
