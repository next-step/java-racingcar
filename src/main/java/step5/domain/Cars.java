package step5.domain;

import step5.domain.stretagy.MovingStrategy;
import step5.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public void setUp(List<String> names, MovingStrategy movingStrategy) {
        for (String name : names) {
            carList.add(new Car(name, movingStrategy));
        }
    }
    public void race() {
        for (Car car : carList) {
            car.race();
        }
    }

    public List<String> getNowResult(ResultView resultView) {
        List<String> nowResultList = new ArrayList<>();
        for (Car car : carList) {
            String eachResult = resultView.makeResult(car.getName(), car.getNowPosition());
            nowResultList.add(eachResult);
        }
        return nowResultList;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getNowPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getNowPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("차량이 생성되어 있지 않습니다."));
    }

}
