package edu.nextstep.stepone;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 14:32
 */
public class Operator {

    /*
    2개의 숫자를 파라미터로 전달받아 덧셈 하는 기능
     */
    int add(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    /*
    2개의 숫자를 파라미터로 전달받아 뺄셈 하는 기능
     */
    int minus(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    /*
    2개의 숫자를 파라미터로 전달받아 곱셈 하는 기능
     */
    int multiply(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    /*
    2개의 숫자를 파라미터로 전달받아 나눗셈 하는 기능
     */
    int divided(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }


    /*
    전달받은 연산자를 구분하여 계산메서드 호출
     */
    public int doOperation(String letter, int firstNumber, int secondNumber) {
        switch (letter) {
            case "+": return this.add(firstNumber, secondNumber);
            case "-": return this.minus(firstNumber, secondNumber);
            case "*": return this.multiply(firstNumber, secondNumber);
            default : return this.divided(firstNumber, secondNumber);
        }
    }
}
