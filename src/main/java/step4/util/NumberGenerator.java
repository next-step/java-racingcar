package step4.util;

@FunctionalInterface
public interface NumberGenerator {
    int BOUND = 10;

    int getValue();

}
