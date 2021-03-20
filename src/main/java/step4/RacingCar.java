package step4;


import step4.dto.InputDto;
import step4.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {

    private final List<Car> carList;
    private final InputDto inputDto;

    public RacingCar(InputDto inputDto) {
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

    public void findWinner() {
        int maxDistance = maxDistance();

        String winnerList = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

        ResultView.printWinner(winnerList);
    }

    private int maxDistance() {
        carList.sort((o1, o2) -> o2.getDistance() - o1.getDistance());
        return carList.get(0).getDistance();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
