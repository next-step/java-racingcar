package carRacing;


import java.util.ArrayList;
import java.util.Random;

public class CarRacing {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printNumberOfCars();
        int numberOfCars = inputView.inputNumber();

        inputView.printNumberOfRacing();
        int numberOfRacing = inputView.inputNumber();

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i<numberOfCars; i++) {
            cars.add(new Car());
        }

        // start
        Random random = new Random();
        for (int round = 1; round <= numberOfRacing; round++) {
            System.out.println();
            if (round == 1) {
                System.out.println("실행결과");
            }
            for (Car car : cars) {
                int position = car.go(random);
                StringBuilder state = new StringBuilder();
                for (int i = 0; i < position; i++) {
                    state.append("-");
                }
                System.out.println(state);
            }
        }
    }
}
