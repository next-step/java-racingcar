package calculator;

public interface Operation {

    boolean isSupport(String operator);

    int operate(int a, int b);

}
