public class ParseParentheses {
    public String parse(String input) {
        int count = 2;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (count == 2) {
                if (input.charAt(i) == '(') {
                    count--;
                } else {
                    result.append(input.charAt(i));
                }
            } else if (count == 1) {
                if (input.charAt(i) == ')') {
                    count--;
                } else {
                    result.append(input.charAt(i));
                }
            } else {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }
}
