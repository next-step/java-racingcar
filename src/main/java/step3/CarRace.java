package step3;

import
import step3.car.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> carList = new ArrayList<>();
    private int carNumber;
    private int executionNumber;

    private CarRace(int carNumber, int executionNumber) {
        this.carNumber = carNumber;
        this.executionNumber = executionNumber;
    }

    public static CarRace getInstance(int carNumber, int executionNumber) {
        return new CarRace(carNumber, executionNumber);
    }

    public void start() {
        자동차 생성 기능
        커맨드 생성 기능
        =수행횟수 만큼 표기 기능
        자동차를 리스트로 받은 후 수행횟수 만큼 rendering 수행시
                수행시 표기여부 체크
    }
}
