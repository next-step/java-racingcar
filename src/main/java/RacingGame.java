import model.Car;
import service.GameStrategy;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private final List<Car> cars = new ArrayList();

    private final GameStrategy strategy;

    public RacingGame(GameStrategy strategy, int carNumber) {
        this.strategy = strategy;
        for(int  i = 0 ; i < carNumber ; i++){
            this.cars.add(new Car());
        }
    }

    public void play(){
        cars.stream().forEach((car)->moveCarByStrategy(car));
    }

    private void moveCarByStrategy(Car car){
        String currentPosition = car.getCurrentPosition();
        System.out.println(currentPosition);
        if(!this.strategy.isCarMove()){
            return;
        }
        car.move();
    }
}