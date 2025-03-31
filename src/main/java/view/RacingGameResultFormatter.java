package view;

import java.util.List;

public class RacingGameResultFormatter {

    private final List<RoundResultFormatter> roundResultFormatters;

    public RacingGameResultFormatter(List<RoundResultFormatter> roundResultFormatters) {
        this.roundResultFormatters = roundResultFormatters;
    }

    public String formatRacingGameResult() {
        StringBuilder result = new StringBuilder();
        result.append("실행 결과").append("\n");
        for (RoundResultFormatter formatter : roundResultFormatters) {
            result.append(formatter.formatCarStatuses()).append("\n");
        }
        return result.toString();
    }
}
