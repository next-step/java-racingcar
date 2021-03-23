package step5.domain;

import step5.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    // Car 객체 생성 같은 것들은 일급 컬렉션에게 위임 (꿀팁 감사합니다 ㅎㅎ)
    private final CarList carList;

    public RacingGame(CarList carList) {
        this.carList = carList;
    }

    public void start(int tryCount) {
        List<Car> cars = this.carList.getCarList();

        for (int i = 0; i < tryCount; ++i) {
            move(cars);
        }
    }

    // 음.. 이것도 Car 클래스 내부에 있어야 더 적합할 거 같은 느낌도 있는데 어떻게 생각하시는지 궁금합니다 !!
    private void move(List<Car> cars) {
        for (int i = 0; i < cars.size(); ++i) {
            Car car = cars.get(i);
            car.move(new RandomMovingStrategy());
            ResultView.print(car);
        }

        System.out.println();
    }

}
