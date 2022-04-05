package me.devyonghee.basic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

class StringNumbers {

    private final Collection<StringNumber> numbers;

    StringNumbers(Collection<StringNumber> numbers) {
        this.numbers = numbers;
    }

    static StringNumbers from(String[] strings) {
        return new StringNumbers(Arrays.stream(strings)
                .map(StringNumber::from)
                .collect(Collectors.toList()));
    }

    static StringNumbers empty() {
        return new StringNumbers(Collections.emptySet());
    }

    int positiveSum() {
        return numbers.stream()
                .map(StringNumber::zeroOrPositiveInt)
                .reduce(0, Integer::sum);
    }
}
