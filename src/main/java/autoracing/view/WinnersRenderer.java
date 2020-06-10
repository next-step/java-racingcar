package autoracing.view;

import autoracing.domain.Car;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinnersRenderer {
    private static final Pattern PHRASE_FORMAT_REGEX = Pattern.compile("^(?:(?!%s).)*%s(?!.*%s).*$");
    private static final String BAD_PHRASE_FORMAT = "the phrase format includes '%s' only once.";

    private final String phraseFormat;
    private final CharSequence delimiter;

    public WinnersRenderer(String phraseFormat, CharSequence delimiter) {
        if (!PHRASE_FORMAT_REGEX.matcher(phraseFormat).matches()) {
            throw new IllegalArgumentException(BAD_PHRASE_FORMAT);
        }

        this.phraseFormat = phraseFormat;
        this.delimiter = delimiter;
    }

    public String render(List<Car> winners) {
        return String.format(phraseFormat, renderWinners(winners));
    }

    private String renderWinners(List<Car> winners) {
        return winners.stream().map(Car::getName).collect(Collectors.joining(delimiter));
    }
}
