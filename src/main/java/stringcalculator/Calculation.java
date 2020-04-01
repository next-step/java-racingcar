package stringcalculator;

@FunctionalInterface
public interface Calculation {
    double calculate(double sum, double nextNumber);
}
