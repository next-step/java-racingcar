package study;

class StringAddCalculator {

    private StringAddCalculator() {
        throw new IllegalStateException("Utility class");
    }
    public static int sum(String inputNumbers){
        if(isInputValidate(inputNumbers)){
            int sum=0;
            String[] inputArray = inputNumbers.split(",");
            for (String inputElement : inputArray) {
                sum+=Integer.parseInt(inputElement);
            }
            return sum;
        }
        return 0;
    }

    private static boolean isInputValidate(String inputNumbers) {
        return inputNumbers != null && !inputNumbers.isEmpty();
    }
}
