package stage2;

public class Calculator {
    public Integer calculate(String input) {

        if (" ".equals(input) || "".equals(input) || input == null) {
            throw new IllegalArgumentException();
        }

        String[] split = input.split(" ");
        Integer init = Integer.parseInt(split[0]);
        String operation = "";

        for (int i = 2; i < split.length; i++) {
            if (i % 2 == 0) {
                operation = split[i - 1];
                Integer first = init;
                Integer second = Integer.parseInt(split[i]);

                Operation op = Operation.findOperation(operation);
                init = op.operate(first, second);
            }
        }

        return init;
    }
}
