package calculator;

import calculator.decision.DecisionType;
import calculator.decision.DecisionTypeChecker;
import calculator.input.CalculatorInputType;
import calculator.input.CalculatorInputTypeChecker;
import java.util.*;

// 사용자가 입력한 문자열 값에 따라 사칙 연산을 수행할 수 있는 계산기를 구현해야 한다.
// 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
// 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
// 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
public class Calculator {
    private Stack<Character> stack;

    private double process(double number, DecisionType decisionType){
        OneLineSolver oneLineSolver = new OneLineSolver();
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String st = sb.reverse().toString();
        double num = Double.parseDouble(st);
        return oneLineSolver.solve(number, num, decisionType);
    }

    public double solve(String input) throws Exception {
        if(input.length() == 0){
            throw new Exception("계산할 대상이 없습니다. input length : 0");
        }

        stack = new Stack<>();
        double result = 0;
        DecisionType decisionType = DecisionType.NONE;
        CalculatorInputType prevCalculatorInputType = CalculatorInputType.NONE;
        int len = input.length();
        int cur = 0;

        for( char ch : input.toCharArray()){
            CalculatorInputType check = CalculatorInputTypeChecker.check(ch);
            switch (check){
                case EMPTY:
                    switch(prevCalculatorInputType){
                        case NUMBER: // "6' '+ 8-"
                            result = process(result, decisionType);
                            break;
                        case CALCULATE: // "6 +' '8 -"
                            break;
                    }
                    break;
                case NUMBER:
                    stack.push(ch);
                    if(cur == len - 1){
                        result = process(result, decisionType);
                    }
                    break;
                case CALCULATE:
                    decisionType = DecisionTypeChecker.check(ch);
                    break;
                case ERROR:
                    break;
            }
            cur++;
            prevCalculatorInputType = check;
        }
        return result;
    }
}
