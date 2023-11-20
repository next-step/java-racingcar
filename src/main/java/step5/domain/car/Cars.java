package step5.domain.car;

import step5.domain.Referee;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars defaultOf(String names) {
        List<Car> cars = new ArrayList<>();
        String[] nameArray = names.split(",");

        for (String name: nameArray) {
            cars.add(Car.defaultOf(name.trim()));
        }

        return new Cars(cars);
    }

    public static Cars defaultOf(List<Car> cars) {
        return new Cars(cars);
    }
    public Cars deepCopy() {
        List<Car> deepCopyCars = new ArrayList<>();
        for (Car car :cars) {
            deepCopyCars.add(car.deepCopy());
        }
        return Cars.defaultOf(deepCopyCars);
    }

    public boolean hasSize(int questionSize) {
        return cars.size() == questionSize;
    }

    public Cars voteWinner() {
        Car winnerCar = this.findWinnerCar();
        return this.findJointWinner(winnerCar);
    }

    private Cars findJointWinner(Car winnerCar) {
        List<Car> winners = new ArrayList<>();
        for (Car each: cars){
            this.judgeJointWinner(winnerCar, each, winners);
        }
        return Cars.defaultOf(winners);
    }

    private void judgeJointWinner(Car winnerCar, Car each, List<Car> winner) {
        if (each.sameDistance(winnerCar)) {
            winner.add(each);
        }
    }

    private Car findWinnerCar() {
        Car winner = cars.get(0);
        for (Car each : this.cars) {
            winner = this.judgeWinner(each, winner);
        }
        return winner;
    }

    private Car judgeWinner(Car car, Car winner) {
        if (car.fartherThan(winner)) {
            winner = car;
        }
        return winner;
    }

    public void go(Referee referee) {
        for (Car car: this.cars) {
            car.move(referee.judgeToMove());
        }
    }

    public Cars makeHistory(){
        return this.deepCopy();
    }

    public String statusToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.cars) {
            stringBuilder.append(car.statusToString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    public int count() {
        return this.cars.size();
    }

    public String toStringWinner() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.cars) {
            stringBuilder.append(car.nameToString());
            stringBuilder.append(", ");
        }
        String winners = stringBuilder.toString().trim();
        return winners.substring(0, winners.length() - 1);
    }
}
