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

            Operation operation = FourOperation.of(operator);
            a = operation.apply(a, b);
        }

        return a;
    }
}
