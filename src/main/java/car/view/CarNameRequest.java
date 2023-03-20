package car.view;

import car.domain.Car;
import car.domain.CarList;

import java.util.*;

public class CarNameRequest {

    private final CarList carList;

    public CarNameRequest(CarList carList) {
        this.carList = carList;
    }

    public static CarNameRequest carListRequest() {
        List<Car> carNameList = new ArrayList<>();
        String carNames = nameRequest();

        for (String carName : carNames.split(",")) {
            carNameList.add(new Car(carName));
        }

        return new CarNameRequest(new CarList(carNameList));
    }

    private static String nameRequest() {
        InputView inputView = new InputView();
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return inputView.getScString();
    }

    public CarList getCarNameList() {
        return carList;
    }


}
