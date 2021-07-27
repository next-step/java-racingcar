package racingcar.car;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    private List<Car> winnerCars;

    public void setCarsByUserInputNames() {
        String names[] = InputView.inputNameOfCars();

        for (int i = 0; i < names.length; i++) {
            addCars(names[i]);
        }
    }

    private void addCars(String name) {
        cars.add(new Car(name));
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
            car.printCarStatus();
        }
        System.out.println();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void produceResult(){
        judgeWinnerCars();
        printWinnerCars();
    }
    private void judgeWinnerCars() {

        winnerCars = cars.stream()
                .collect(groupingBy(Car::getPosition))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .get()
                .getValue();

    }

    private void printWinnerCars() {
        ResultView.printWinnerCars(winnerCars);
    }
}
