package step4.domain;

import step4.util.ConvertUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Race {

    private Set<Car> cars;
    private int numOfCars;
    private int rounds;

    public void setUpRace(String[] carNames, int rounds) {
        this.numOfCars = carNames.length;
        this.rounds = rounds;
        this.setCars(carNames);
    }

    public void runOneRound() {
        CarMove carMove = new CarMove();

        for (Car car : this.cars) {
            car.move(carMove.checkMovable());
        }
    }

    public String getRaceWinners() {
        int maxStep = this.cars.stream()
                .mapToInt(Car::getSteps)
                .max()
                .orElseThrow(RuntimeException::new);

        Set<String> winningCars = this.cars.stream()
                .filter(car -> car.getSteps() == maxStep)
                .map(Car::getName)
                .collect(Collectors.toSet());

        return ConvertUtil.appendToString(winningCars);
    }

    private void setCars(String[] carNames) {
        cars = new HashSet<>(this.numOfCars);

        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public int getNumOfRounds() {
        return this.rounds;
    }

}
