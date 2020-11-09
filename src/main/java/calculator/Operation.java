package calculator;

@FunctionalInterface
public interface Operation {
    int calculate(int first, int second);
}
