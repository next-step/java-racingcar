package camp.nextstep.edu.racingcar.view.formatter;

import camp.nextstep.edu.racingcar.domain.Round;
import camp.nextstep.edu.racingcar.domain.Rounds;

import java.util.stream.Collectors;

public class RoundsFormatter implements Formatter<Rounds> {

    private static final String DELIMITER_ROUNDS = "\n\n";

    private final Formatter<Round> roundFormatter;

    public RoundsFormatter(Formatter<Round> roundFormatter) {
        this.roundFormatter = roundFormatter;
    }

    @Override
    public String format(Rounds rounds) {
        return rounds.stream()
                .map(roundFormatter::format)
                .collect(Collectors.joining(DELIMITER_ROUNDS));
    }
}
