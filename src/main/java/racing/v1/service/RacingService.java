package racing.v1.service;

import racing.v1.model.Car;
import racing.v1.util.RandomGenerator;
import racing.v1.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    private int carCount;
    private int moveCount;

    public int getCarCount() {
        return carCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setCarCount(int carCount){
        this.carCount = carCount;
    }

    public void setMoveCount(int moveCount){
        this.moveCount = moveCount;
    }

    public void showResult(ResultView resultView){
        List<Car> cars = generateCarList(carCount);

        System.out.println("실행 결과");

        for(int i = 0; i < moveCount; i++){
            for(Car car : cars){
                if(isCarMove()) {
                    car.move();
                }
                resultView.printCarMove(car);
            }
            resultView.printStepEnd();
        }
    }

    private List<Car> generateCarList(int carCount) {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carCount; i++){
            cars.add(new Car());
        }
        return cars;
    }

    private boolean isCarMove(){
        return RandomGenerator.generate() >= 4;
    }
}
