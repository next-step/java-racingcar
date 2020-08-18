package carracing.domain;

import carracing.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private int carCount = 0;
    private int tryCount = 0;
    private List<Car> cars = null;

    public Game(int carCount, int tryCount){
        inputValid(carCount, tryCount);

        this.tryCount = tryCount;
        this.cars = this.generateCars(carCount);

    }

    private void inputValid(int carCount, int tryCount) {
        if( carCount == 0 || tryCount == 0) throw new IllegalArgumentException("입력값을 확인해주세요.");
    }

    public void start() {
        for(int i = 0; i < this.tryCount; i++) {
            play();
        }
    }

    private List<Car> generateCars(int carCount) {
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= carCount; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
        return cars;
    }

    private void play() {
        for(Car car : cars) {
            car.setPosition();
            this.viewOutPut(car);
        }
        System.out.println("");
    }

    private void viewOutPut(Car car) {
        OutputView outputView = new OutputView();
        outputView.getResultView(car);
    }
}