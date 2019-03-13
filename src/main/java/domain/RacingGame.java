package domain;

import domain.*;

import io.Input;
import io.Output;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RacingGame {
    private Rule rule;
    private Integer gameCount;
    private List<Car> cars = new ArrayList<>();

//    private Input input;
//    private Output output;

    private RacingGame(Rule rule, int gameCount){
        this.rule = rule;
        this.gameCount = gameCount;
    }

    public RacingGame(Rule rule, int gameCount, int carCount) {
        this(rule, gameCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public RacingGame(Rule rule, int gameCount, String[] carNames) {
        this(rule, gameCount);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<Car> play(){
        if(rule == null || gameCount == null || cars.size() == 0){
            throw new IllegalStateException("Have to init first");
        }

        for (int i = 0; i < gameCount; i++) {
            playCycle();
        }

        return cars;
    }

    private void playCycle(){
        cars.stream()
            .filter(c -> rule.canPass())
            .forEach(Car::move);
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
