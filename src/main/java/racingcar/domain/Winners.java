package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static racingcar.domain.Cars.findWinners;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public static String getWinnersNames(List<Car> winners) {
        List<String> winnersNamesList = collectWinnerNames(winners);
        StringBuffer winnerNamesBuffer = new StringBuffer();
        winnerNamesBuffer.append(winnersNamesList.get(0));
        for (int i = 1; i < winnersNamesList.size() ; i++) {
            winnerNamesBuffer.append(", ");
            winnerNamesBuffer.append(winnersNamesList.get(i));
        }
        return winnerNamesBuffer.toString();
    }

    private static List<String> collectWinnerNames(List<Car> winners) {
        return findWinners(winners).stream( )
                .map(o -> o.getCarName( ))
                .collect(Collectors.toList( ));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
