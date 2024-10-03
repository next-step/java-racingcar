package race.Utils;

@FunctionalInterface
public interface NumberGenerator {
    int bound = 10;

    int getValue();
}
