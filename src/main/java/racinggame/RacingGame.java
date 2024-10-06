package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = Cars.of(carCount);
    }

    public void moveAll(){
        Random random = new Random();
        for (int i=0;i<cars.count();i++){
            cars.mode(i,random.nextInt(10));
        }
    }
}
