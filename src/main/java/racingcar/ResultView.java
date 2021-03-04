package racingcar;

public class ResultView {

    public void printEachCar(Car car) {
        for (int i = 0; i < car.getCountMove(); i++) {
            System.out.print("-");
        }
    }

    public void printResult(Car[] cars) {
        for (Car car : cars) {
            printEachCar(car);

            System.out.println();
        }

        System.out.println();
    }
}
