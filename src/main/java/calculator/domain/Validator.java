package calculator.domain;

public class Validator {

    public static void validate(String userInput){
        String[] split = userInput.split(" ");
        isNumber(split);
    }

    public static void isNumber(String[] split) {
        for (int i = 0; i < split.length; i+=2) {
            if(split[i].length() == 0 || !Character.isDigit(split[i].charAt(0))){
                throw new IllegalArgumentException("[ERROR] 입력형식이 맞지 않습니다.");
            }
        }
    }


}
