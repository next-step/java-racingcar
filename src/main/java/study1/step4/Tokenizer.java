package study1.step4;

public class Tokenizer {

    public static void TokenListValidate(String racerListString){
        if(Validator.inputValidate(racerListString)){
            throw new IllegalArgumentException("입력값 확인해주세요");
        }
    }

    public static String[] getList(String raceListString){
        return raceListString.split(",");
    }
}
