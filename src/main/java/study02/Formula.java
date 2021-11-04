package study02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Formula {

    private final List<Operand> operandList;
    private final List<Operator> operatorList;

    public Formula(String formula) {
        if (formula == null) {
            throw new IllegalArgumentException("수식 문자열이 Null 입니다.");
        }
        if (formula.trim().length() == 0) {
            throw new IllegalArgumentException("수식 문자열은 비어있을 수 없습니다");
        }

        String[] splitFormula = formula.split(" ");

        Arrays.stream(splitFormula)
                .filter(it -> !Operand.isValid(it) && !Operator.isValid(it))
                .findAny()
                .ifPresent(it -> {
                    throw new IllegalArgumentException(String.format("연산자, 피연산자로 사용이 불가능한 문자가 있습니다. %s", it));
                });

        this.operandList = Arrays.stream(splitFormula)
                .filter(Operand::isValid)
                .map(Operand::new)
                .collect(Collectors.toList());

        this.operatorList = Arrays.stream(splitFormula)
                .filter(Operator::isValid)
                .map(Operator::of)
                .collect(Collectors.toList());

        if (operandList.isEmpty()) {
            throw new IllegalArgumentException("피연산자가 1개 이상이 필요합니다.");
        }
        if (operatorList.isEmpty()) {
            throw new IllegalArgumentException("연산자가 1개 이상이 필요합니다.");
        }
        if (operandList.size() - operatorList.size() != 1) {
            throw new IllegalArgumentException("연산자와 피연산자의 개수가 올바르지 않습니다.");
        }
    }

    public List<Operand> getOperandList() {
        return this.operandList;
    }

    public List<Operator> getOperatorList() {
        return this.operatorList;
    }
}
