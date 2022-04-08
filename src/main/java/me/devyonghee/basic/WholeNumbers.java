package me.devyonghee.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

final class WholeNumbers {

    private final Collection<WholeNumber> numbers;

    WholeNumbers(Collection<WholeNumber> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    static WholeNumbers from(Collection<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("'strings' must not be null");
        }
        return new WholeNumbers(strings.stream()
                .map(WholeNumber::from)
                .collect(Collectors.toList()));
    }

    WholeNumber sum() {
        return numbers.stream()
                .reduce(WholeNumber.ZERO, WholeNumber::add);
    }

    @Override
    public String toString() {
        return "WholeNumbers{" +
                "numbers=" + numbers +
                '}';
    }
}
