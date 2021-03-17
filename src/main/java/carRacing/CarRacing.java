package carRacing;

import carRacing.model.Car;
import carRacing.util.RandomIntUtil;
import carRacing.view.OutputView;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacing {
    final static String DELIMITER = ",";
    private List<Car> cars;
    private OutputView outputView;

    public CarRacing(String carNames) {
        checkStringParam(carNames);
        this.cars = new ArrayList<>();
        outputView = new OutputView();
        enrollCars(carNames);
    }

    private void checkStringParam(String carNames) {
        if(StringUtils.isBlank(carNames))
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        if(Arrays.stream(carNames.split(DELIMITER)).anyMatch(s -> s.length()>5)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void checkIntParam(int param) {
        if(param <= 0)
            throw new IllegalArgumentException("유효한 양의 정수를 입력하세요");
    }

    public void startRacing(int racingCount) {
        checkIntParam(racingCount);
        System.out.println("실행 결과");
        for (int i = 0; i < racingCount; i++) {
            System.out.printf("try%2d.%n", i + 1 );
            excuteCycle();
            outputView.printRacingResultExcutedCycle(cars);
        }
    }

    private void excuteCycle() {
        for (Car car : cars) {
            car.moveByRandomInt(RandomIntUtil.getRandomInt());
        }
    }

    private void enrollCars(String carNames) {
        String[] carNameList = carNames.split(DELIMITER);
        Arrays.stream(carNameList).forEach(carName -> this.cars.add(new Car(carName)));
    }

    public List<Car> getCars() {
        return cars;
    }
}
