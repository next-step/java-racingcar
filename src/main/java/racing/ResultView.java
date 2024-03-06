package racing;

import java.util.List;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printRaceResult(List<Car> carList) {
        List<Position> positions = Car.carPositions(carList);

        positions.stream()
                .map(Position::dashOfPosition)
                .forEach(System.out::println);

        System.out.println();
    }
}
