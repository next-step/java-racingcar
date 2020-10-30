import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operands {
    private final Queue<Operand> operands;

    public Operands(List<String> strs) {
        this.operands = strs.stream()
                .map(Operand::new)
                .collect(Collectors.toCollection(LinkedList::new));
    }


    private static class Operand {
        private final int num;

        public Operand(String str) {
            this.num = Integer.parseInt(str);
        }

        @Override
        public String toString() {
            return String.valueOf(num);
        }
    }
}
