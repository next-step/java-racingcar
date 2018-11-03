package calculator;

/**
 * Created by hspark on 02/11/2018.
 */
@FunctionalInterface
public interface IntCalculator extends Calculator<Integer, Integer, Integer> {
	@Override
	Integer calculate(Integer from, Integer to);
}
