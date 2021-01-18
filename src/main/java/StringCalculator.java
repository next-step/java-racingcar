public class StringCalculator {

    public int calculate(final String s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("");
        }

        String[] elements = s.split(" ");
        if (elements.length % 2 != 1) {
            throw new IllegalArgumentException("");
        }

        int result = toInt(elements[0]);
        for (int i = 1; i < elements.length; i += 2) {
            String operator = elements[i];
            int num = toInt(elements[i + 1]);
            result = action(result, num, operator);
        }
        return result;
    }

    public int action(int left, int right, String operator) throws IllegalArgumentException {
        if (operator.equals("+")) {
            return left + right;
        } else if (operator.equals("-")) {
            return left - right;
        } else if (operator.equals("*")) {
            return left * right;
        } else if (operator.equals("/")) {
            if (right == 0) {
                throw new IllegalArgumentException("");
            }
            return left / right;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public int toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
    }
}
