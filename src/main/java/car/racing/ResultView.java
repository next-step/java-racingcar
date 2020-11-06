package car.racing;

import java.util.List;

public class ResultView implements CarRacingContract.View {

    @Override
    public void resultTitle() {
        System.out.println("\n실행 결과");
    }

    @Override
    public void newLine() {
        System.out.println();
    }

    @Override
    public void forward(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.forwardResult()));
    }
}