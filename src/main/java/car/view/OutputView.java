package car.view;

import car.domain.Name;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printWinners(List<Name> winnerNames) {
        String joinedWinnerNames = winnerNames.stream()
            .map(Name::getValue)
            .collect(Collectors.joining(", "));

        System.out.println(joinedWinnerNames + "가 최종 우승했습니다.");
    }
}
