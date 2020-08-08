package stringCalculator;

public interface Operation {
    boolean isSupport(String operator);

    int operate(int x, int y);
}
