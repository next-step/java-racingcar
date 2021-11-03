package calculator;

/**
 * Created by owen.ny on 2021/11/03.
 */
@FunctionalInterface
public interface Calculable {
    MyNumber apply(MyNumber first, MyNumber second);
}
