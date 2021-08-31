package stage2;

public class Expression {
    private final String[] data;
    private int init;

    public Expression(String[] data) {
        this.data = data;
        this.init = Integer.parseInt(data[0]);
    }

    public int express() {
        for (int i = 2; i < data.length; i+=2) {
            String operation = data[i - 1];
            int first = init;
            int second = Integer.parseInt(data[i]);

            Operation op = Operation.findOperation(operation);
            init = op.operate(first, second);
        }
        return init;
    }
}
