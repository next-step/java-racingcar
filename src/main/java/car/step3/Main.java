package car.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        HandleCar handleCar = new HandleCar();
        ResultView resultView = new ResultView();
        //자동차 대수
        int carNumber = inputView.scannerCarCertain();
        //시도할 횟수
        int number = inputView.scannerCarNumber();
        List<Car> carList = new ArrayList<Car>();

        //입력 받은 자동차 대수만큼 차를 생성하여 리스트에 넣는다.
        for (int i = 0; i < carNumber; i++) {
            Car car = new Car();
            carList.add(car);
        }
        // 시도할 횟수만큼 시도한다. 랜덤 값이 4 이상이면 전진한다.
        for (int i = 0; i < number; i++) {
            carList = handleCar.iteratorCar(carList);
            resultView.result(carList);
        }
    }
}
