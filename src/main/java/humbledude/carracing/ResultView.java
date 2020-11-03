package humbledude.carracing;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    public void printHeader() {
        System.out.println("실행 결과");
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.printf("%5s : ", car.getName());
        IntStream.range(0, car.getPosition())
                .forEach(i -> System.out.print("-"));
    }
}
