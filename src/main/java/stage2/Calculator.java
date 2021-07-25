package stage2;

public class Calculator {
    public Integer execute(String input) {
        String[] split = input.split(" ");
        Integer init = Integer.parseInt(split[0]);
        String operation = "";

        for (int i = 2; i < split.length; i++) {
            if (i % 2 == 0) {
                operation = split[i - 1];
                Integer first = init;
                Integer second = Integer.parseInt(split[i]);

                Operation op = Operation.findOperation(operation);
                init = op.calculate(first, second);
            }
        }

        return init;
    }
}
