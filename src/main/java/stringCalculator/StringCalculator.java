package stringCalculator;

public class StringCalculator {

    public String calculate(String problem) {
        if (problem.equals("")) {
            throw new IllegalArgumentException("공백 문자를 입력하였습니다.");
        }

        String[] problemArr = problem.split(" ");

        String a = problemArr[0];

        for (int i = 1; i < problemArr.length; i+=2) {
            String operator = problemArr[i];
            String b = problemArr[i+1];

            a = calculateOne(a, b, operator);
        }

        return a;
    }

    public String calculateOne(String a, String b, String operator) {
        if (operator.equals("+")) {
            return FourOperation.PLUS.apply(a,b);
        }else if(operator.equals("-")){
            return FourOperation.MINUS.apply(a,b);
        }else if(operator.equals("*")){
            return FourOperation.MULT.apply(a,b);
        }else if(operator.equals("/")){
            return FourOperation.DIVIDE.apply(a,b);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닌 문자를 입력하였습니다.");
    }

}
