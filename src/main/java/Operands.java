import java.util.List;
import java.util.stream.Collectors;

public class Operands {
    private final List<Operand> operands;

    public Operands(List<String> strs) {
        this.operands = strs.stream()
                .map(Operand::new)
                .collect(Collectors.toList());
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
