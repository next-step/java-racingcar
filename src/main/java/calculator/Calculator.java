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
    private double result;
    private DecisionType decisionType;
    private CalculatorInputType prevCalculatorInputType;
    private int cur;

    public Calculator(){
        this.stack = new Stack<>();
        this.result = 0;
        this.decisionType = DecisionType.NONE;
        this.prevCalculatorInputType = CalculatorInputType.NONE;
        this.cur = 0;
    }

    private double calculate(double number, DecisionType decisionType){
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
        int len = input.length();

        for( char ch : input.toCharArray()){
            CalculatorInputType check = CalculatorInputTypeChecker.check(ch);
            if(check.equals(CalculatorInputType.EMPTY)){
                emptyInputSolve();
            }
            if(check.equals(CalculatorInputType.NUMBER)){
                numberInputSolve(ch, len);
            }
            if(check.equals(CalculatorInputType.CALCULATE)){
                decisionType = DecisionTypeChecker.check(ch);
            }
            cur++;
            prevCalculatorInputType = check;
        }
        return result;
    }

    private void emptyInputSolve() {
        if(prevCalculatorInputType.equals(CalculatorInputType.NUMBER)){
            result = calculate(result, decisionType);
        }
    }

    private void numberInputSolve(char ch, int len) {
        stack.push(ch);
        if(cur == len - 1){
            result =  calculate(result, decisionType);
        }
    }
}
