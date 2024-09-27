public class StringAddCalculator {
    public static void validNegative(int num) throws RuntimeException{
        if (num < 0) {
            throw new RuntimeException();
        }
    }

    public static int emptyOrNull(String input) {
        if(input == null||input.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
