public class StringAddCalculator {

    public static int splitAndSum(String text){
        InputText inputText = InputText.from(text);
        if(inputText.isBlank()) {
            return 0;
        }
        return sum(toPositiveNumbers(inputText.split()));
    }

    private static int sum(PositiveNumber[] numbers) {
        int result = 0;
        for(PositiveNumber number : numbers){
            result += number.getValue();
        }
        return result;
    }

    private static PositiveNumber[] toPositiveNumbers(String[] tokens) {
        PositiveNumber[] result = new PositiveNumber[tokens.length];
        for(int i = 0; i < tokens.length; i++) {
            result[i] = PositiveNumber.from(tokens[i]);
        }
        return result;
    }
}
