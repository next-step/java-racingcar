import calculator.Calculator;
import calculator.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import racing.Car;
import racing.CarGenerator;
import racing.Racing;

public class Application {

    public static void main(String[] args) throws IOException {
        List<Car> cars = readyCars();
        startRacing(cars);
    }

    private static void startRacing(List<Car> cars) throws IOException {
        Racing racing = new Racing(cars);
        racing.race();
    }

    private static List<Car> readyCars() throws IOException {
        String[] names = CarGenerator.readCarName();
        List<Car> cars = CarGenerator.generateCars(names);
        return cars;
    }

}
