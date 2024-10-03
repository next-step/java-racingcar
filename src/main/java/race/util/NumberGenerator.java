package race.util;

@FunctionalInterface
public interface NumberGenerator {
    int bound = 10;

    int getValue();

}
