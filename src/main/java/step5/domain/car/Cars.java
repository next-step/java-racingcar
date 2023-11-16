package step5.domain.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars defaultOf(String names) {
        List<Car> cars = new ArrayList<>();
        String[] nameArray = names.split(",");

        for (String name: nameArray) {
            cars.add(Car.defaultOf(name));
        }

        return new Cars(cars);
    }

    public static Cars defaultOf(List<Car> cars) {
        return new Cars(cars);
    }

    public boolean hasSize(int questionSize) {
        return cars.size() == questionSize;
    }

    public List<Car> voteWinner() {
        Car winnerCar = this.findWinnerCar();
        return this.findJointWinner(winnerCar);
    }

    private List<Car> findJointWinner(Car winnerCar) {
        List<Car> winner = new ArrayList<>();
        for (Car each: cars){
            this.judgeJointWinner(winnerCar, each, winner);
        }
        return winner;
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

    private Car judgeWinner(Car each, Car winner) {
        if (each.fartherThan(winner)) {
            winner = each;
        }
        return winner;
    }

}
