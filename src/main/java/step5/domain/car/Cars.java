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

    public Cars findFartherestCars() {
        Car winnerCar = this.findFartherestDistanceCar();
        return this.findSameDistanceCars(winnerCar);
    }

    private Cars findSameDistanceCars(Car comparisonStandardCar) {
        List<Car> sameDistanceCars = new ArrayList<>();
        for (Car car: cars){
            this.judgeSameDistanceCars(comparisonStandardCar, car, sameDistanceCars);
        }
        return Cars.defaultOf(sameDistanceCars);
    }

    private void judgeSameDistanceCars(Car comparisonStandardCar, Car each, List<Car> sameDistanceCars) {
        if (each.sameDistance(comparisonStandardCar)) {
            sameDistanceCars.add(each);
        }
    }

    private Car findFartherestDistanceCar() {
        Car fartherest = cars.get(0);
        for (Car each : this.cars) {
            fartherest = this.judgeFartherDistanceCar(each, fartherest);
        }
        return fartherest;
    }

    private Car judgeFartherDistanceCar(Car car, Car fartherestCar) {
        if (car.fartherThan(fartherestCar)) {
            return car;
        }
        return fartherestCar;
    }

    public Cars go(Referee referee) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car: this.cars) {
            movedCars.add(car.move(referee.judgeToMove()));
        }
        return Cars.defaultOf(movedCars);
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
