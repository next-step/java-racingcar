package calculator;

@FunctionalInterface
public interface Calculable {
    MyNumber apply(MyNumber first, MyNumber second);
}
