import domain.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    protected int gameCount;
    protected List<Car> cars = new ArrayList<>();

    protected Condition condition;
    protected Input input;
    protected Output output;

    public RacingGame(Input input, Output output, Condition condition){
        this.input = input;
        this.output = output;
        this.condition = condition;
    }

    public void init(){
        output.setGameCount();
        int gameCount = input.nextInt();

        output.setCarCount();
        int carCount = input.nextInt();

        this.gameCount = gameCount;
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void play(){
        output.startMessage();
        for (int i = 0; i < gameCount; i++) {
            playCycle();
        }
    }

    private void playCycle(){
        for (Car car : cars) {
            if(condition.canPass())
                car.move();
        }

        output.carMileage(cars);
    }
}
