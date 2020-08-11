package cc.oakk.racing.view.printer;

import cc.oakk.racing.domain.Car;
import cc.oakk.racing.domain.Ranking;

import java.util.List;
import java.util.stream.Collectors;

public class RankingPrinter extends StringPrinter<Ranking> {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "";
    private static final String SUFFIX = "가 최종 우승했습니다.";

    @Override
    public void print(Ranking source) {
        if (source.size() < 0) {
            throw new IllegalArgumentException("Ranking's size is below 0.");
        }

        List<Car> winners = source.getWinner();
        String joinedResult = winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));

        stringPrinter.print(joinedResult);
    }
}
