package camp.nextstep.edu.calculator;

public interface StringCalculator<T extends Number> {
    T calculate(String expression);
}
