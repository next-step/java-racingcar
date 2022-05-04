package racing.domain;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.MovableStrategy;
import racing.view.Input;
import racing.view.View;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private final Input input;
    private final View view;
    private final MovableStrategy movableStrategy;

    public Application(Input input, View view, MovableStrategy movableStrategy) {
        this.input = input;
        this.view = view;
        this.movableStrategy = movableStrategy;
    }

    public void run() {
        String[] carNames = input.readCars();
        int tryCnt = input.readTryCnt();
        Cars cars = generateCars(carNames);

        for(int i=0; i<tryCnt; i++){
            cars.moveAll();
            view.printRaceResult(cars.getCurPositionResult());
        }

        view.printGameResult(cars);
    }

    private Cars generateCars(String[] carNames){
        List<Car> carList = new ArrayList<>();
        for (String name: carNames) {
            carList.add(new Car(movableStrategy, name));
        }
        return new Cars(carList);
    }


}
