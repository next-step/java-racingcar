import model.Car;
import model.GameResult;
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

    public GameResult play(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < cars.size();  i++){
            Car car = cars.get(i);
            builder.append(car.getCurrentPosition());
            moveCarByStrategy(car);
        }
        return new GameResult(builder.toString());
    }

    void moveCarByStrategy(Car car){
        if(!this.strategy.isCarMove()){
            return;
        }
        car.move();
    }
}