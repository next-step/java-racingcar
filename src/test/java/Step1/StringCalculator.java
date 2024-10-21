package Step1;

public class StringCalculator {

    private double _result;

    public StringCalculator() { _result = 0; }

    enum OP_TYPE {
        NONE,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    public double calc(String input) {
        String[] splits = input.split(" ");

        _result = 0;
        OP_TYPE op = OP_TYPE.NONE;

        for (String s : splits) {
            op = calc_op(s, op);
        }

        return _result;
    }

    private OP_TYPE calc_op(String word, OP_TYPE op) {
        if (word.equals("+")) { return OP_TYPE.ADD;}
        if (word.equals("-")) { return OP_TYPE.SUBTRACT;}
        if (word.equals("*")) { return OP_TYPE.MULTIPLY;}
        if (word.equals("/")) { return OP_TYPE.DIVIDE;}

        double cur_integer = Double.parseDouble(word);

        if (op ==OP_TYPE.NONE) { _result = cur_integer; return OP_TYPE.NONE; }
        if (op == OP_TYPE.ADD) { _result += cur_integer; return OP_TYPE.NONE; }
        if (op == OP_TYPE.SUBTRACT) { _result -= cur_integer; return OP_TYPE.NONE; }
        if (op == OP_TYPE.MULTIPLY) { _result *= cur_integer; return OP_TYPE.NONE; }
        if (op == OP_TYPE.DIVIDE) { _result /= cur_integer; return OP_TYPE.NONE; }

        return OP_TYPE.NONE;
    }
}
