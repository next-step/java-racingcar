package calculator;

public interface Operation {
    boolean isSupport(String operator);
    int operator(int x, int y);
}
