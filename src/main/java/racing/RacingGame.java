package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final static int MAX_TIME = 100;
    private final static int MAX_CARS = 100;
    private final static int MIN_TIME = 1;
    private final static int MIN_CARS = 1;
    private int time;
    private List<Car> cars;
    
    public RacingGame() {
        this.cars = new ArrayList<>();
    }
    
    public int[] move() {
        // TODO 구현
        return null;
    }
    
    public void setTime(int time) {
        if (time > MAX_TIME || time < MIN_TIME) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_TIME.getMessage());
        }
        this.time = time;
    }
    
    public void makeCars(int count) {
        if (count > MAX_CARS || count < MIN_CARS) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_CAR_COUNT.getMessage());
        }
    
        IntStream.range(0, count).forEach((i) -> cars.add(new Car(i)));
    }
      
    public int getTime() {
        return time;
    }
    
    public List<Car> getCars() {
        return cars;
    }
}