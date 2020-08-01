package stringcalculator;

public class StringCalculator {
    // 입력 문자열의 '숫자' 와 '사칙연산' 사이 반드시, 빈 공백 문자열, final 변수 지정
    //******** SPLIT DELIMITER & REGEX 학습 필요 *************//
    private static final String DELIMITER = " ";

    //Singleton 생성자 유지
    //******** null값 에러, 인스턴스화 방지 로직 구별 필요 *************//

    private final String expression;

    public StringCalculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException(" ");
        }
        this.expression = expression;
    }

    //******** 심화 : Colletion API 활용하여 숫자, 연산자 관리  *************//
    //******** 심화 : Scanner.input 통해 parseInt 및 반복문 적용 *************//
    public int calculate(){
        String[] splitExpression = expression.split(" ");
        int number = Integer.parseInt(splitExpression[0]);
        // num, op, num -> for 구문 (i = i+2), 이후 number은 parseInt(i+1)
        for (int i = 1; i < splitExpression.length; i = i + 2) {
            StringCalOperator strOperation = StringCalOperator.findOperation(splitExpression[i]);
            number = strOperation.applyAsInt(number, Integer.parseInt(splitExpression[i + 1]));
        }
        return number;
    }

}


