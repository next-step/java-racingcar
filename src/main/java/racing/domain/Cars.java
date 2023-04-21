package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars { // 일급컬렉션
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Car theCar(int index) {
        return this.cars.get(index);
    }

    public int size() {
        return this.cars.size();
    }

    public Cars playOnceTurn() {

        List<Car> movedCars = new ArrayList<>();
        RandomGameRule randomGameRule = new RandomGameRule();

        for (int i = 0; i < this.cars.size(); i++) {
            int randomNumber = randomGameRule.getPossibleInt();
            Car car = this.cars.get(i).move(randomNumber);
            movedCars.add(car);
        }
        return new Cars(movedCars);
    }

    public List<String> findWinners() {

        List<String> winners = new ArrayList<>();
        int maxLocation = maxLocation();

        for (int i = 0; i < this.cars.size(); i++) {
            addOnlyWinner(winners, maxLocation, i);
        }
        return winners;
    }

    private void addOnlyWinner(List<String> winners, int maxLocation, int i) {
        if (checkWinner(maxLocation, this.cars.get(i))) {
            winners.add(this.cars.get(i).name());
        }
    }

    private boolean checkWinner(int maxLocation, Car car) {
        if (car.isWinner(maxLocation)) {
            return true;
        }
        return false;
    }

    public int maxLocation() {
        int maxLocation = 0;
        for (int i = 0; i < this.cars.size(); i++) {
            maxLocation = this.cars.get(i).bigger(maxLocation);
        }
        return maxLocation;
    }
}
