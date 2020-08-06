package step3.output;

import step3.domain.Car;
import step3.domain.CarRacingRapScore;

import java.util.List;

public class ResultView {

    private static final Character MARK = '-';

    private List<CarRacingRapScore> rapResults;

    public ResultView(List<CarRacingRapScore> rapResults) {
        this.rapResults = rapResults;
    }

    public void printResult() {
        System.out.println("실행 결과");
        rapResults.forEach(this::printPositions);
    }

    private void printPositions(CarRacingRapScore score) {
        score.getCars().forEach(this::printPositionOfAttempt);
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
