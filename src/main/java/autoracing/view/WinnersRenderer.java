package autoracing.view;

import autoracing.domain.Car;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static autoracing.domain.AssertUtils.assertNotNull;

public class WinnersRenderer {
    private static final Pattern PHRASE_FORMAT_REGEX = Pattern.compile("^(?:(?!%s).)*%s(?!.*%s).*$");
    private static final String BAD_PHRASE_FORMAT = "the phrase format includes '%s' only once.";
    private static final String NULL_PHRASE_FORMAT = "phrase format must be not null.";
    private static final String NULL_DELIMITER = "delimiter must be not null.";

    private final String phraseFormat;
    private final CharSequence delimiter;


    public WinnersRenderer(String phraseFormat, CharSequence delimiter) {
        assertNotNull(phraseFormat, NULL_PHRASE_FORMAT);
        assertNotNull(delimiter, NULL_DELIMITER);

        if (!PHRASE_FORMAT_REGEX.matcher(phraseFormat).matches()) {
            throw new IllegalArgumentException(BAD_PHRASE_FORMAT);
        }

        this.phraseFormat = phraseFormat;
        this.delimiter = delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnersRenderer that = (WinnersRenderer) o;
        return phraseFormat.equals(that.phraseFormat) &&
                delimiter.equals(that.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phraseFormat, delimiter);
    }

    public String render(List<Car> winners) {
        return String.format(phraseFormat, renderWinners(winners));
    }

    private String renderWinners(List<Car> winners) {
        return winners.stream().map(Car::getName).collect(Collectors.joining(delimiter));
    }
}
