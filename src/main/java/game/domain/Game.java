package game.domain;

import game.util.ResultView;

import java.util.List;

public class Game {
    private final NumberGenerator generator;
    private final List<Car> cars;

    public Game(NumberGenerator generator, List<Car> cars) {
        this.generator = generator;
        this.cars = cars;
    }

    public void play(){
        for (Car car : cars) {
            int number = generator.getNumber();
            car.move(number);
        }
    }

    public void printResult(){
        for(Car car : cars){
            car.printDistance();
        }
        ResultView.printPlainMessage("");
    }
}
