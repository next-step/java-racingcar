package stringcalculator.operation;

@FunctionalInterface
public interface Operator {
    Double excute(Double x, Double y);
}
