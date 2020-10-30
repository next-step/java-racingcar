import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operators {
    private final Queue<Operator> operators;


    public Operators(List<String> strs) {
        this.operators = strs.stream()
                .map(Operator::fromOpChar)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private enum Operator {
        PLUS("+");

        private final String opChar;

        Operator(String opChar) {
            this.opChar = opChar;
        }

        public static Operator fromOpChar(String opChar) {
            return Arrays.stream(Operator.values())
                    .filter(o -> o.opChar.equals(opChar))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("Wrong operator: " + opChar));
        }

        @Override
        public String toString() {
            return opChar;
        }
    }
}

