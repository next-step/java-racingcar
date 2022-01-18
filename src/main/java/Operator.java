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
}
