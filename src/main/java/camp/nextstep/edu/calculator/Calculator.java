package camp.nextstep.edu.calculator;

public interface Calculator<T extends Number> {
    T calculate(String expression);
}
