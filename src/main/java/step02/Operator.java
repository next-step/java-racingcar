package step02;

import exception.DividedByZero;

/*
- 코드를 보면서 알게된 자바의 열거형 사용방법
    - 구조: 생성자(최초 init setter), 열거형 타입(?), 열거형 getter 들
    - 열거형 생성자의 인자 -> 열거형 타입의 메서드의 인자
    - 열거형을 implements 할 경우 열거형 타입들(메서드?) 안에서 각각 모두 구현을 해주어야함.
    - 열거형을 외부에서 사용하게 될 때 내부 에서 무엇을 어떻게 리턴하고 접근하는가?
    - 열거형은 보통 대문자를 사용
    - 열거형 내부의 메서드는 public 으로 선언해 주어야 하는가?
 */
public enum Operator implements Operation {

    PLUS("+") {
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },

    MINUS("-") {
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    },

    DIVIDE("/") {
        @Override
        public int calculate(int first, int second) {
            if (second == 0) {
                throw new DividedByZero();
            }
            return first / second;
        }
    },

    MULTIPLE("*") {
        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    };


    /*
    - 최초 한번 생성자에서 초기화 하기위해 final 로 선언
     */
    private final String operatorType;

    /*
    - 열거형의 생성자인가?
    - 열거형의 생성자를 열거형 타입 보다 아래에 적는 이유가 무엇인가? 문법인가?
     */
    Operator(String operatorType) {
        this.operatorType = operatorType;
    }

    /*
    - 열거형
     */
    public String getOperatorType() {
        return operatorType;
    }

}
