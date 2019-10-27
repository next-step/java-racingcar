package step1.calculator;

public class StringCalculator<T> {
    private final EquationResolver<T> equationResolver;

    public StringCalculator(String type) {
        this.equationResolver = EquationResolverFactory.getEquationResolver(type);
    }

    public T calculate(String equation) {
        try{
            return equationResolver.resolveEquation(equation).operate();
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(String.format("Invalid input equation, equation=[%s]", equation));
        }
    }
}
