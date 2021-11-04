package study02;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Operand {

    private final long operand;

    public Operand(String operand) {
        this(Long.parseLong(operand));
    }

    public Operand(long operand) {
        this.operand = operand;
    }

    public static List<Operand> parse(String[] formula) {
        List<Operand> operandList = Arrays.stream(formula)
                .filter(it -> !Operator.valid(it))
                .map(Operand::new)
                .collect(Collectors.toList());

        Collections.reverse(operandList);

        return operandList;
    }

    public long getValue() {
        return this.operand;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Operand) {
            return this.operand == ((Operand) obj).operand;
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return String.valueOf(this.operand);
    }
}
