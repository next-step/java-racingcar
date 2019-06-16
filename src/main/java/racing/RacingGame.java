package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    public final static int MAX_TIME = 100;
    public final static int MAX_CARS = 100;
    public final static int MIN_TIME = 1;
    public final static int MIN_CARS = 1;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int MOVABLE_MIN_NUMBER = 4;
    private List<Car> cars;
    private RandomNumberGenerator randomNumberGenerator;
    private int time;
    
    public RacingGame(int carCount, int time) {
        makeCars(carCount);
        setTime(time);
        randomNumberGenerator = new RandomNumberGenerator(MAX_RANDOM_NUMBER);
    }
    
    public void startRacing() {
        IntStream.range(0, time).forEach(i -> {
            cars.stream()
              .filter(car -> isMovable(randomNumberGenerator.getNumber()))
              .forEach(car -> car.forward());
            cars.forEach(car -> {
                String movePoint = "";
                for (int j = 0; j < car.getPosition(); j++) {
                    movePoint += "-";
                }
                System.out.println(car.getName() + " : " + movePoint);
            });
        });
    }
    
    public List<Car> move() {
        return null;
    }
    
    public static boolean isMovable(int randomNumber) {
        return randomNumber >= MOVABLE_MIN_NUMBER;
    }
    
    private void setTime(int time) {
        if (time > MAX_TIME || time < MIN_TIME) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
        this.time = time;
    }
    
    private void makeCars(int count) {
        if (count > MAX_CARS || count < MIN_CARS) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
        }
    
        cars = new ArrayList<>();
        IntStream.range(0, count).forEach((i) -> cars.add(new Car(i)));
    }
      
    public int getTime() {
        return time;
    }
    
    public List<Car> getCars() {
        return cars;
    }
}