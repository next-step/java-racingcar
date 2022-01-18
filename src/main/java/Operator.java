import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operator {

    private String[] arr = {"+", "-", "*", "/"};
    private List<String> symbols = new ArrayList<>(Arrays.asList(arr));
    private List<String> operators;

    public Operator() {
        operators = new ArrayList<>();
    }

    public void addOperator(String ope) {
        if (!symbols.contains(ope)) {
            throw new IllegalArgumentException("연산기호가 아닙니다.");
        }
        operators.add(ope);
    }

    public void print() {
        System.out.println("Opeartor Class========");
        for (String s : operators) {
            System.out.println(s);
        }
    }
}
