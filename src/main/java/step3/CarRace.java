package step3;

import step3.RenderView.RenderView;
import step3.car.Car;
import step3.car.CarFactory;
import step3.command.CommandFactory;
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
        if (carNumber < 1 || executionNumber < 1) {
            throw new IllegalArgumentException("getInstance의 인자는 1 미만의 값을 받을 수없습니다.");
        }
        return new CarRace(carNumber, executionNumber);
    }

    public void start() {
        // 자동차 생성
        this.carList = CarFactory.createCarList(carNumber);
        // 커맨드 세팅
        this.carList.forEach((car) -> car.setCommandList(CommandFactory.createCommandList(executionNumber)));
        // 카레이스 진행상황 표기
        RenderView.getInstance("-")
                  .showCarRace(this.carList, executionNumber);
    }
}
