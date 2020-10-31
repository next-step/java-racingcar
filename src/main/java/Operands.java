import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Operands {
    private final List<Integer> operands;

    public Operands(List<String> strs) {
        this.operands = strs.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public int poll() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("operands is empty");

        int num = this.operands.get(0);
        this.operands.remove(0);
        return num;
    }

    public boolean isEmpty() {
        return operands.isEmpty();
    }

    public void add(int operand) {
        operands.add(0, operand);
    }
}
