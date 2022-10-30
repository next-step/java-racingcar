package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printResult(RacingGame game) {
        System.out.println("실행 결과");
        System.out.println(game.getCars().toString());

        List<String> winners = new RacingWinnerCalculator(game.getCars()).winners()
                .stream()
                .map(RacingCar::name)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
