package calculator;

// TDD 교육이 되어 있을때 작성한 소스 입니다.
// 추상클래스로 CLASS 정의 후, 그대로 구현 하기를 목표로 작성한 추상클래스 입니다.
abstract class Calculator_Abstract {
    abstract int caculate(String text);

    abstract int add(int a, int b);

    abstract int subtract(int a, int b);

    abstract int multiply(int a, int b);

    abstract int divide(int a, int b);
}
