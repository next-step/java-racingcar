package calculator;

/**
 * 실제 연산로직을 정의하기위한 인터페이스 
 */
@FunctionalInterface
public interface OperationFunc {
	int execute(int a, int b);
}
