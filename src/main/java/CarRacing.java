import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    public static void main(String[] args) {

        String[] nameOfCars = InputView.splitNameOfCars();
        int trial = InputView.trial();

        Cars cars = new Cars(cars(nameOfCars));
        cars.race(trial);
        List<Car> winners = cars.winners();

        PrintView.printTitle();

        for (int i = 0; i < trial; i++) {
            PrintView.printCar(cars, i);
        }
    }

    private static List<Car> cars(String[] nameOfCars) {
        List<Car> cars = new ArrayList<>();
        for (String nameOfCar : nameOfCars) {
            cars.add(new Car(nameOfCar, 0));
        }

        return cars;
    }
}
