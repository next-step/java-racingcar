import java.util.List;
import java.util.stream.IntStream;

public class CarRacing {

    public static void main(String[] args) {

        String[] nameOfCars = InputView.splitNameOfCars();
        int trial = InputView.trial();

        Cars cars = new Cars(Cars.makeCars(nameOfCars));
        cars.race(trial);
        List<Car> winners = cars.winners();

        PrintView.printTitle();

        IntStream.range(0, trial).
                forEach(round -> PrintView.printCar(cars, round));

        PrintView.printWinners(winners);
    }
}
