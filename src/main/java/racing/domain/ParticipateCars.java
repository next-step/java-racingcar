package racing.domain;

import racing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParticipateCars {
    private static final List<Car> cars = new ArrayList<>();

    public ParticipateCars() {
    }

    public ParticipateCars(String[] cars) {
        createCar(cars);
    }

    protected List<Car> createCar(String[] carNames) {
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        return new ArrayList<>(this.cars);
    }

    public void moveCar() {
        for (Car car : this.cars) {
            int randomNumber = RandomGenerator.getRandomNumber();
            car.run(randomNumber);
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(this.cars);
    }

    public String winner() {
        int numOfWinnerByCondition = 2;
        int maxTotalMeter = findMaxTotalMeter(cars);
        List<String> winner = findWinnerName(maxTotalMeter,cars);
        return winnerName(winner, numOfWinnerByCondition);
    }

    protected List<String> findWinnerName(int maxTotalMeter,List<Car> cars) {
        List<String> winner = new ArrayList<>();
        cars.forEach(car->{
            if (car.totalMeter() == maxTotalMeter) {
                winner.add(car.getName());
            }
        });
        return winner;
    }

    protected int findMaxTotalMeter(List<Car> cars){
        return cars.stream()
                    .max(Car::compareTo)
                    .map(Car::totalMeter)
                    .get();
    }



    private String winnerName(List<String> winners, int numOfWinnerOption) {
        String winner = "";
        int numberOfWinners = winners.size();
        if (numberOfWinners < numOfWinnerOption) {
            winner = winners.get(0);
        }
        if (numberOfWinners > numOfWinnerOption || winners.size() == numOfWinnerOption) {
            winner = winners.stream().collect(Collectors.joining(","));
        }
        return winner;
    }

}
