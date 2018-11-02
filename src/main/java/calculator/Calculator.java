package calculator;

/**
 * Created by hspark on 02/11/2018.
 */
@FunctionalInterface
public interface Calculator<T, U, R> {
	R calculate(T from, U to);
}
