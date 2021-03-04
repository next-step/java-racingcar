package step2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.util.stream.Collectors.toCollection;
import static step2.Constants.SPLIT_DELIMITER;

/**
 * 사칙 연산 관련 데이터를 관리할 클래스
 */
public final class MathContext {

    // 사칙 연산의 순서와 관계 없이 순차적으로 처리되기 때문에 Queue의 자료구조를 사용
    private final Queue<Integer> numbers;
    private final Queue<Operator> operations;

    // 사용자의 입력 값을 처리할 필드
    private String[] formula;

    public MathContext(String userInput) {
        processFormula(userInput);
        this.numbers = setNumbers(formula);
        this.operations = setOperations(formula);
    }

    private void processFormula(String formula) {
        this.formula = formula.split(SPLIT_DELIMITER);
    }

    // 사용자의 입력 값 -> Operation 값만 필터링 -> Operator로 파싱 -> LinkedList 타입으로 반환
    public final LinkedList<Operator> setOperations(final String[] userInput) {
        return Arrays.stream(userInput)
                .filter(Operator::isOperation)
                .map(Operator::getOperator)
                .collect(toCollection(LinkedList::new));
    }

    // 사용자의 입력 값 -> 숫자만 필터링 -> 숫자로 파싱 ->  LinkedList 타입으로 반환
    public final LinkedList<Integer> setNumbers(final String[] userInput) {
        return Arrays.stream(userInput)
                .filter(Validator::isNumeric)
                .map(Integer::parseInt)
                .collect(toCollection(LinkedList::new));
    }

    public Queue<Integer> getNumbers() {
        return numbers;
    }

    public Queue<Operator> getOperations() {
        return operations;
    }

}
