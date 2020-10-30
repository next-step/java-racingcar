package step02;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    /*
    - private 으로 선언한 이유?
        - 외부에서 사용할 일이 없음
    - static 으로 선언한 이유?
        - 모든 인스턴스가 공유함
    - final 으로 선언한 이유?
        - Map 자료형은 항상 final 로 선언하는가?
    - 타입이 Map 인 이유?
    - Map 의 자료형이 어떻게 생겼나? <> 안에 있는 것은 Genetic 인가?
    - OPERATIONS 대문자로 선언한 이유는 final 이기 때문일 것
    - HashMap 자료형이 무엇?
    - Operation : 인터페이스는 인터페이스를 구현한 thing 의 자료형이 될 수 있는가?
        - (Operator 연산자) ㅇ 피연산자(Operand)에 연산(Operation)을 가하도록하는 도구
     */
    private static final Map<String, Operation> OPERATIONS = new HashMap<>();

    /*
    - 블록 앞에 static 을 선언하는 것은 무슨 문법인가?
        - new 를 하여 인스턴스를 생성하지 않아도 실행되는 block 이라 인스턴스들이 공통적으로 가지고 있는 클래스의 블록인가?
    - 블록안에 문을 선언한다는 것은 무슨 의미인가?
    - java 의 for 순회하는 것은 어떤 방식들이 있는가?
    - java 는 한 패키지 안에 자바에서 쓰이는 파일(?)들을 import 하지 않고 사용할 수 있다.
    - Operator.values() 는 열거형 들을 순회하는 것 일듯
    - Operator 의 생성자 호출은 어디있지?
    - Operator operator 의 operator 는 각 열거형 요소라고 생각했는데 getOperatorType 을 메서드로 호출하고 있다니 무슨일이지?
    - operator 는 무엇일까? 찍어봐야겠다.
        - System.out.println(operator);   // PLUS MINUS DIVIDE MULTIPLE
        - System.out.println(operator.getOperatorType()); // + - / *
        - 열거형 원소에서 열거형의 메서드를 사용할 수 있다.
        - 열거형 원소에서 초기화가 이루어 진다? 이 때 열거형의 매개변수는 생성자의 매개 변수와 같다?
     */
    static {
        for (Operator operator : Operator.values()) {
            OPERATIONS.put(operator.getOperatorType(), operator);
        }
    }

    private boolean isNullOrEmpty(String inputData) {
        return inputData == null || inputData.length() == 0;
    }

    private boolean isBlank(String inputData) {
        return inputData.trim().length() == 0;
    }

    /*
    - isNullOrEmpty / isBlank
        - 함수의 역할을 확실하게 설명해 주는 이름인 것 같다
     */
    private void validateInputDataIsEmpty(String inputData) {
        if (isNullOrEmpty(inputData) || isBlank(inputData))
            throw new IllegalArgumentException(CalculatorError.ARGS_EMPTY);
    }

    /*
    - 클래스의 메인, 요구사항을 수행함
    - final 로 선언한 이유는 inputData 가 불변성을 유지하는 것이 필요해서 인가?
     */

    /*

     */
    private void validateOperatorType(String operatorType) {
        if (!OPERATIONS.containsKey(operatorType))
            throw new IllegalArgumentException(CalculatorError.INVALID_OPERATOR);
    }

    /*
    - 위에서 아래로 읽는 것이 가독성에 더 좋을 것 같아 원본에서 함수의 위치들을 calculate 함수 위로 모두 옮겼다
    - validateIsCorrectOperatorType -> validateOperatorType 이름을 변경하였다.
    - Operation operator = OPERATIONS.get(operatorType); 대입으로 사용할 열거형을 바로 선택할 수 있나?
     */
    public int calculate(final String inputData) {

        validateInputDataIsEmpty(inputData);

        String[] rowData = inputData.split(" ");

        int calculateResult = Integer.parseInt(rowData[0]);

        for (int i = 1; i < rowData.length - 1; i += 2) {
            String operatorType = rowData[i];

            validateOperatorType(operatorType);

            int rightOperand = Integer.parseInt(rowData[i + 1]);
            int leftOperand = calculateResult;

            Operation operator = OPERATIONS.get(operatorType);
            calculateResult = operator.calculate(leftOperand, rightOperand);
        }

        return calculateResult;
    }
}
