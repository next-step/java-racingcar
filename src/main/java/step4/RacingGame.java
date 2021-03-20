package step4;


import step4.dto.InputDto;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<Car> carList;
    private final InputDto inputDto;

    public RacingGame(InputDto inputDto) {
        this.carList = createCar(inputDto.getCarNameList());
        this.inputDto = inputDto;
    }

    public void start() {
        int tryCount = inputDto.getTryCount();

        for (int i = 0; i < tryCount; ++i) {
            move();
        }
    }

    private void move() {
        for (int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            car.carCanGoJudge(RandomNumber.randomNumberGenerator());

            // move 랑 print 를 분리할 수는 없을까요.. ㅠ,ㅠ (print 메소드에서 매개변수로 Car를 받으니 분리하기가 애매하네요..)
            print(car);
        }

        System.out.println();
    }

    private void print(Car car) {
        ResultView.print(car);
    }

    private List<Car> createCar(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNameList.size(); ++i) {
            cars.add(new Car(carNameList.get(i)));
        }

        return cars;
    }

    public String findWinner() {
        int maxDistance = maxDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private int maxDistance() {
        carList.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
        return carList.get(0).getDistance();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
