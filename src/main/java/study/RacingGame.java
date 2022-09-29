package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {


    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        resultView.racingResult(carMoveCount(makeCarList(inputView.carCount()), inputView.tryCount()));
    }

    public static List<Car> makeCarList(int count) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++){
            carList.add(new Car());
        }
        return carList;
    }

    public static List<Car> carMoveCount(List<Car> carList, int count){
        for(Car car : carList) {
            for(int i = 0; i < count; i++) {
                car.move(getRandom());
            }
        }
        return carList;
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }


}
