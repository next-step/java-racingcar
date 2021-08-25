package carracing.view;

import carracing.domain.Car;
import carracing.domain.RaceResult;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String POSITION_VIEW_STYLE = "-";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void showResult(RaceResult result) {
        for (List<Car> cars : result.raceResult()) {
            showGameResult(cars);
        }

        showWinnerResult(result.winners());
    }

    public void showGameResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.name().value() + " : ");
            sb.append(makePosition(car.position().value()));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private String makePosition(int location) {
        String result = "";
        for (int i = 0; i < location; i++) {
            result += POSITION_VIEW_STYLE;
        }
        return result;
    }

    private void showWinnerResult(List<Car> winners) {
        List<String> names = winners.stream()
            .map(car -> car.name().value()).collect(Collectors.toList());
        System.out.println(String.join(", ", names) + "가 최종 우승했습니다.");
    }

}
