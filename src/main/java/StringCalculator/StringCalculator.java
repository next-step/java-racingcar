package StringCalculator;

public class StringCalculator {

    public int calculate(String input) {
        isEmpty(input);
        String[] value = stringToArray(input);

        int beforeNum = stringToInt(value[0]);

        for(int i = 1; i < value.length; i += 2) {
            int afterNum = stringToInt(value[i + 1]);
            Operator operator = Operator.setOperator(value[i]);
            beforeNum = operator.calculate(beforeNum, afterNum);
        }
        return beforeNum;
    }

    private void isEmpty(final String input) {
        if(input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("Can not input EMPTY value");
        }
    }

    private String[] stringToArray(String input) {
        return input.split(" ");
    }

    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
