import java.util.ArrayList;
import java.util.List;

public class Operator {

    private List<String> operators;

    public Operator() {
        operators = new ArrayList<>();
    }

    public void addOperator(String ope) {
        operators.add(ope);
    }

    public void print() {
        System.out.println("Opeartor Class========");
        for (String s : operators) {
            System.out.println(s);
        }
    }
}
