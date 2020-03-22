import java.util.List;
import java.util.Random;

public class GameRole {

    private int numberOfCars;
    private int numberOfAttempts;
    private List<Car> cars;
    private Random random;


    public GameRole(int numberOfCars, int numberOfAttempts) {
        this.numberOfCars = numberOfCars;
        this.numberOfAttempts = numberOfAttempts;
        this.random = new Random();
    }

    public void prepareGame() {
        cars = CarFactory.createCars(numberOfCars);
    }

    public void playGame() {
        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                int condition = random.nextInt(10);
                car.move(condition);
            }
        }
    }
}
