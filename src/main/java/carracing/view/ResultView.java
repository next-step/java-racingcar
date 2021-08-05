package carracing.view;

import carracing.domain.Car;
import carracing.domain.RaceResult;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void showResult(RaceResult result) {
        showGameResult(result.raceResult());
        showWinnerResult(result.winners());
    }

    public void showGameResult(List<String> raceResults) {
        for (String raceResult : raceResults) {
            System.out.println(raceResult);
        }
    }

    private void showWinnerResult(List<Car> winners) {
        List<String> names = winners.stream()
            .map(car -> car.name()).collect(Collectors.toList());
        System.out.println(String.join(", ", names) + "가 최종 우승했습니다.");
    }

}
