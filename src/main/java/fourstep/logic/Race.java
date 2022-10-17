package fourstep.logic;


import java.util.ArrayList;
import java.util.stream.IntStream;

public class Race {

    private final ArrayList<String> winners = new ArrayList<>();

    private ArrayList<Car> cars = new ArrayList<>();
    private int raceCount = 0;

    public Race(String[] carNames, int raceCount) {
        this.raceCount = raceCount;
        int carCount = carNames.length;
        IntStream.range(0, carCount).forEach(i -> cars.add(new Car(carNames[i])));
    }

    public Race(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<String> play(RandomNumber random) {
        IntStream.range(0, raceCount).mapToObj(i -> random).forEach(this::carsMove);
        return getWinners();
    }


    public void carsMove(RandomNumber random) {
        for (Car car : cars) {
            car.move(random.getRandomNumber());
        }
    }


    public ArrayList<String> getWinners() {
        int maxLocation = getMaxLocation();
        for (Car car : cars) {
            checkMaxCar(car, maxLocation);
        }
        return winners;
    }

    public int getMaxLocation() {
        int maxLocation = 0;
        for (Car car : cars) {
            maxLocation = car.maxLocation(maxLocation);
        }
        return maxLocation;
    }


    private void checkMaxCar(Car car, int maxLocation) {
        if (car.isMaxLocation(maxLocation)) {
            winners.add(car.getName());
        }
    }


    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
