package edu.nextstep.racingcar.step1;

import java.util.Set;

public class CollectionUtils {

    private final Set<Integer> numbers;

    public CollectionUtils(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getSize() {
        return this.numbers.size();
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
