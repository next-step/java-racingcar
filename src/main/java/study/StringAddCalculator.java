package study;

class StringAddCalculator {

    private StringAddCalculator() {
        throw new IllegalStateException("Utility class");
    }
    public static int sum(String inputNumbers){
        if(isInputValidate(inputNumbers)){
            // do sum
        }
        return 0;

    }

    private static boolean isInputValidate(String inputNumbers) {
        return inputNumbers != null && !inputNumbers.isEmpty();
    }
}
