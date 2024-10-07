package racingcar.domain;

@FunctionalInterface
public interface CreationStrategy {
    Cars create(final String names);
}
