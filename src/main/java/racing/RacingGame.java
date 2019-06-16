package racing;

import racing.common.ErrorMessage;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    public final static int MAX_TIME = 50;
    public final static int MAX_CARS = 50;
    public final static int MIN_TIME = 1;
    public final static int MIN_CARS = 1;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int MOVABLE_MIN_NUMBER = 4;
    private final static int START_NUMBER = 0;
    private List<Car> cars;
    private RandomNumberGenerator randomNumberGenerator;
    private int time;
    
    public RacingGame(String carNames, int time) {
        makeCars(carNames);
        setTime(time);
        randomNumberGenerator = new RandomNumberGenerator(MAX_RANDOM_NUMBER);
    }
    
    private void makeCars(int count) {
        if (count > MAX_CARS || count < MIN_CARS) {
            throwException(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
        }
        
        cars = new ArrayList<>();
        IntStream.range(START_NUMBER, count)
          .forEach(i -> cars.add(new Car(i)));
    }
    
    private static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
    
    private void setTime(int time) {
        if (time > MAX_TIME || time < MIN_TIME) {
            throwException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
        this.time = time;
    }
    
    public void startRacing() {
        IntStream.range(0, time)
          .forEach(i -> { 
              cars.stream()
                .filter(car -> isMovable(randomNumberGenerator.getNumber()))
                .forEach(Car::forward);
              ResultView.printCarsMoving(cars);
        });
    }
    
    public static boolean isMovable(int randomNumber) {
        return randomNumber >= MOVABLE_MIN_NUMBER;
    }
         
    public int getTime() {
        return time;
    }
    
    public List<Car> getCars() {
        return cars;
    }
}