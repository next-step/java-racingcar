package study.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class RoundManager {

    public static final String LESS_THAN_OR_EQUAL_ZERO = "round 값은 0보다 커야합니다 -> ";
    public static final String NON_NULL = "toDoList 값은 null 일수 없습니다";
    private final List<Runnable> toDoList;

    public RoundManager() {
        this.toDoList = new ArrayList<>();
    }

    public void startRace(int round, List<Runnable> toDoList) {
        validation(round, toDoList);
        addToDoList(toDoList);
        IntStream.range(0, round)
                .forEach(index -> startRound());
    }

    private void validation(int round, List<Runnable> toDoList) {
        requireGreaterThanZero(round);
        requireNonNull(toDoList);
    }

    private void requireGreaterThanZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(LESS_THAN_OR_EQUAL_ZERO + number);
        }
    }

    private void requireNonNull(List<Runnable> toDoList) {
        if (Objects.isNull(toDoList)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void addToDoList(List<Runnable> toDoList) {
        this.toDoList.clear();
        this.toDoList.addAll(toDoList);
    }

    private void startRound() {
        toDoList.forEach(Runnable::run);
    }
}
