package stage2;

public class Expression {
    private String[] data;
    private Integer init;
    private String operation;

    public Expression(String[] data) {
        this.data = data;
        this.init = Integer.parseInt(data[0]);
    }

    public Expression(String[] data, Integer init) {
        this.data = data;
        this.init = init;
        this.operation = "";
    }

    public Integer express() {
        for (int i = 2; i < data.length; i+=2) {
            operation = data[i - 1];
            Integer first = init;
            Integer second = Integer.parseInt(data[i]);

            Operation op = Operation.findOperation(operation);
            init = op.operate(first, second);
        }
        return init;
    }
}
