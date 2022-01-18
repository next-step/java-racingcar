package calculator.domain;

public class Validator {
    private static String operators = "+-*/";

    public static void validateUserInput(String userInput){
        validateIsBlack(userInput);

        String[] split = userInput.split(" ");

        validateOddIndexIsNumber(split);
        validateEvenIndexIsOperator(split);
    }

    private static void validateIsBlack(String userInput) {
        if(userInput.equals("") || userInput.equals(" ")){
            throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
        }
    }

    private static void validateOddIndexIsNumber(String[] split) {
        for (int i = 0; i < split.length; i+=2) {
            validateIsNumber(split[i]);
        }
    }

    private static void validateIsNumber(String target) {
        try {
            Integer.parseInt(target);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
        }
    }


    private static void validateEvenIndexIsOperator(String[] split) {
        for(int i=1; i< split.length; i+=2){
            validateIsOperator(split[i]);
        }
    }

    private static void validateIsOperator(String target) {
        if(!operators.contains(target)){
            throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");

        }
    }
}
