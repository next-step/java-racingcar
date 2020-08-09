package step3.output;

import step3.domain.Car;
import step3.domain.CarRacingRapScore;

import java.text.MessageFormat;
import java.util.List;

public class ResultView {

    private static final String SEPARATOR = " : ";
    private static final String DELIMITER = ",";
    private static final Character MARK = '-';

    private List<CarRacingRapScore> rapResults;

    public ResultView(List<CarRacingRapScore> rapResults) {
        this.rapResults = rapResults;
    }

    public void printResult() {
        System.out.println("실행 결과");
        rapResults.forEach(this::printNamesAndPositions);
        System.out.println(MessageFormat.format("{0}가 최종 우승했습니다.", getCsvNameOfBestScoreCars()));
    }

    private String getCsvNameOfBestScoreCars() {
        CarRacingRapScore finalRapScore = rapResults.get(rapResults.size() - 1);
        List<String> namesOfBestScoreCars = finalRapScore.findBestScoreCarNames();
        return String.join(DELIMITER, namesOfBestScoreCars);
    }

    private void printNamesAndPositions(CarRacingRapScore score) {
        score.getCars().forEach(this::printNamesAndPositionsOfRap);
        System.out.println();
    }

    private void printNamesAndPositionsOfRap(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName());
        builder.append(SEPARATOR);
        for (int i = 0; i < car.getPosition(); i++) {
            builder.append(MARK);
        }
        System.out.println(builder.toString());
    }

}
