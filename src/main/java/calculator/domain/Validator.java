package calculator.domain;

public class Validator {

    public static void validateUserInput(String userInput){
        checkIsBlack(userInput);

        String[] split = userInput.split(" ");

        oddIndexIsNumber(split);
        evenIndexIsOperator(split);
    }

    private static void checkIsBlack(String userInput) {
        if(userInput.equals("") || userInput.equals(" ")){
            throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
        }
    }

    private static void oddIndexIsNumber(String[] split) {
        for (int i = 0; i < split.length; i+=2) {
            isNumber(split[i]);
        }
    }

    private static void isNumber(String target) {
        if(target.length() == 0 || !Character.isDigit(target.charAt(0))){
            throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");
        }
    }


    private static void evenIndexIsOperator(String[] split) {
        for(int i=1; i< split.length; i+=2){
            if(!isOperator(split[i])){
                throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");
            }
        }
    }

    private static boolean isOperator(String target) {
        switch (target){
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }

        return false;
    }
}
