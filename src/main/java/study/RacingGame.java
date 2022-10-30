package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {


    public static void main(String[] args) {
        InputView inputView = new InputView();;
        ResultView resultView = new ResultView();
        resultView.racingResult(carMoveCount(makeCarList(inputView.carName()), inputView.tryCount()));
    }

    public static List<Car> makeCarList(String carName) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNameList(carName).length; i++){
            carList.add(new Car(carNameList(carName)[i]));
        }
        return carList;
    }

    private static String[] carNameList(String carName) {
        String[]carNameList = carName.split(",");
        return carNameList;
    }

    public static List<Car> carMoveCount(List<Car> carList, int count){
        for(Car car : carList) {
            carMoveTry(car,count);
        }
        return carList;
    }

    private static void carMoveTry(Car car,int count) {
        for(int i = 0; i < count; i++) {
            car.move(getRandom());
        }
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }


}
