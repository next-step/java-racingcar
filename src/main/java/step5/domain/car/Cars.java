package step5.domain.car;

import step5.domain.Referee;
import step5.domain.Winners;

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

    public Winners voteWinner() {
        Car winnerCar = this.findWinnerCar();
        return this.findJointWinner(winnerCar);
    }

    private Winners findJointWinner(Car winnerCar) {
        List<Car> winners = new ArrayList<>();
        for (Car each: cars){
            this.judgeJointWinner(winnerCar, each, winners);
        }
        return Winners.of(winners);
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

    public void go(Referee referee) {
        for (Car car: this.cars) {
            car.move(referee.judgeToMove());
        }
    }
}
