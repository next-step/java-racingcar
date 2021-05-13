package car;

import java.util.List;

public class Drive {
    private static final int MAXIMUM_RANDOM_NUMBER = 10;
    private List<Car> cars;
    private Output output;

    public Drive(List<Car> cars) {
        this.cars = cars;
    }

    public void carDrive() {
        for (Car car : cars) {
            int randomNumber = (int) (Math.random() * MAXIMUM_RANDOM_NUMBER);

            car.changeKm(randomNumber);
        }
    }

    public void carRacing(int count) {
        int nowCount = 0;
        output = new Output(cars);

        System.out.println("실행 결과");

        while (nowCount < count) {
            carDrive();

            output.printCars();

            nowCount++;
        }

        output.printWinner();
    }
}
