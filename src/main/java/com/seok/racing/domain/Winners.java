package com.seok.racing.domain;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;

public class Winners {

    private final static String TO_STRING_PATTERN = "{0} 가 최종 우승했습니다.";
    private final static String WINNERS_DELIMITER = ", ";

    private List<Winner> winners;

    protected Winners(List<Winner> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return MessageFormat.format(TO_STRING_PATTERN, join());
    }

    private String join() {
        return winners.stream()
                .map(Winner::toString)
                .collect(joining(WINNERS_DELIMITER));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
