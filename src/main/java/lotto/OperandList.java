package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OperandList {
    private final List<Operand> list;

    public OperandList(List<String> list) {
        this.list = Collections.unmodifiableList(
                list.stream()
                        .map(Operand::new)
                        .collect(Collectors.toList())
        );
    }

    public int sum() {
        return list
                .stream()
                .mapToInt(Operand::getValue)
                .sum();
    }
}
