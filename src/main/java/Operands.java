import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Operands {
    private final Queue<Integer> operands;

    public Operands(List<String> strs) {
        this.operands = strs.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Integer poll() {
        return this.operands.poll();
    }
}
