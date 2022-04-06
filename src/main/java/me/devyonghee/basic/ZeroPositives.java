package me.devyonghee.basic;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

final class ZeroPositives {

    private final Collection<ZeroPositive> numbers;

    ZeroPositives(Collection<ZeroPositive> numbers) {
        this.numbers = numbers;
    }

    static ZeroPositives from(Collection<String> strings) {
        if (strings == null) {
            return new ZeroPositives(Collections.emptyList());
        }
        return new ZeroPositives(strings.stream()
                .map(ZeroPositive::from)
                .collect(Collectors.toList()));
    }

    ZeroPositive sum() {
        return numbers.stream()
                .reduce(ZeroPositive.ZERO, ZeroPositive::add);
    }

    @Override
    public String toString() {
        return "ZeroPositives{" +
                "numbers=" + numbers +
                '}';
    }
}
