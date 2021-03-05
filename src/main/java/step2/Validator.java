package step2;

public class Validator {
    public Validator() {}

    public static void validationCheck(String formula){
        if(null == formula || formula.trim().isEmpty()){
            throw new IllegalArgumentException("문자열이 공백입니다.");
        }
    }
}
