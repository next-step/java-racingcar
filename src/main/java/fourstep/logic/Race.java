package fourstep.logic;

import fourstep.view.ResultView;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Race {

    private ArrayList<Car> cars = new ArrayList<>();
    private final ArrayList<String> winners = new ArrayList<>();

    public Race(String[] carNames) {
        int carCount = carNames.length;
        IntStream.range(0, carCount).forEach(i -> cars.add(new Car(carNames[i])));
    }

    public Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void play(int raceCount, RandomNumber random) {
        ResultView.printResultLine();
        for (int i = 0; i < raceCount; i++) {
            carsMove(random);
            ResultView.printOneRace(cars);
        }
        getWinners();
        ResultView.printWinner(winners);
    }

    private void carsMove(RandomNumber random) {
        for (Car car : cars) {
            car.move(random.getRandomNumber());
        }
    }


    private void checkMaxCar(Car car, int maxLocation) {
        if (car.getLocation() == maxLocation) {
            winners.add(car.getName());
        }
    }

    public int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = Integer.max(car.getLocation(), maxLocation);
        }
        return maxLocation;
    }

    public ArrayList<String> getWinners() {
        int maxLocation = getMaxLocation();
        for (Car car : cars) {
            checkMaxCar(car, maxLocation);
        }
        return winners;
    }
}
