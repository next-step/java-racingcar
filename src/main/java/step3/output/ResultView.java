package step3.output;

import step3.domain.Car;

import java.util.List;

public class ResultView {

    private static final Character MARK = '-';

    private List<List<Car>> rapResults;

    public ResultView(List<List<Car>> rapResults) {
        this.rapResults = rapResults;
    }

    public void printResult() {
        System.out.println("실행 결과");
        rapResults.forEach(this::printPositions);
    }

    private void printPositions(List<Car> cars) {
        cars.forEach(this::printPositionOfAttempt);
        System.out.println();
    }

    private void printPositionOfAttempt(Car car) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(MARK);
        }
        System.out.println(builder.toString());
    }

}
