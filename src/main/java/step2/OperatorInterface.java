package step2;

/**
 * Calculator 에서 BiFunction 의 역할을 담당할 계산기 인터페이스 선언
 */
@FunctionalInterface
public interface OperatorInterface {
    Integer apply(Integer a, Integer b);
}
