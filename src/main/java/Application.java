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
    static final int CAR_NAME_LENGTH = 5;

    public static void main(String[] args) throws IOException {
        List<Car> cars = readyCars();
        startRacing(cars);
    }

    private static void startRacing(List<Car> cars) throws IOException {
        int roundNumber = readRoundNumber();
        Racing racing = new Racing(cars);
        racing.race(roundNumber);
    }

    private static int readRoundNumber() throws IOException {
        System.out.println("시도할 횟수는 몇회인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    private static List<Car> readyCars() throws IOException {
        CarGenerator cg = new CarGenerator(CAR_NAME_LENGTH);
        String[] names = cg.readCarName();
        List<Car> cars = cg.generateCars(names);
        return cars;
    }

}
