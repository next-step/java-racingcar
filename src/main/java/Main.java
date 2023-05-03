import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();

        inputView.startToGameSetting();

        Cars cars = new Cars(createCars(inputView.getTotalOfCars()));

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < inputView.getRound(); i++) {
            cars.move(inputView.getTotalOfCars());
            resultView.show(cars);

            System.out.println();
        }
    }

    private static List<Car> createCars(int totalOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < totalOfCars; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
