package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.ResultView.*;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.getInstance();


        String[] carsName = (inputView.inputCarName()).split(",");
        int carCount = carsName.length;


        Car car = new Car();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            car.addCar(carList);
        }

        car.naming(carsName, carList);
        int tryCount = inputView.inputTryCount();

        for (int i = 0; i < tryCount; i++) {
            resultCars(carList);
        }

        String strings = car.winningCar(carList);
        System.out.println(strings + " 가 최종 우승했습니다.");


    }
}
