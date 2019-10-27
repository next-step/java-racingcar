package step1.calculator;

public interface EquationResolver<T> {
    ProcessUnit<T> resolveEquation(String equation);

    default String [] splitByWhitespace(String s) {
        return s.split("\\s");
    }
}
