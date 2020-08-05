package cc.oakk.racing.printer;

import cc.oakk.racing.Car;
import cc.oakk.racing.Ranking;

import java.util.List;

public class RankingPrinter extends StringPrinter<Ranking> {
    private static final String DELIMITER = ", ";

    @Override
    public void print(Ranking source) {
        if (source.size() < 0) {
            throw new IllegalArgumentException("Ranking's size is below 0.");
        }

        StringBuilder builder = new StringBuilder();
        List<Car> winners = source.getWinner();
        winners.forEach(car -> builder.append(car.getName())
            .append(DELIMITER));

        deleteDelimiter(builder)
            .append("가 최종 우승했습니다.");

        stringPrinter.print(builder.toString());
    }

    private StringBuilder deleteDelimiter(StringBuilder builder) {
        return builder.delete(builder.length() - DELIMITER.length(), builder.length());
    }
}
