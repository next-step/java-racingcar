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

    public Operand poll() {
        return this.operands.poll();
    }
}
