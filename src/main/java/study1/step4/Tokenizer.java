package study1.step4;

public class Tokenizer {

    public void TokenListValidate(String racerListString){
        if(Validator.inputValidate(racerListString)){
            throw new IllegalArgumentException("입력값 확인해주세요");
        }
    }

    public String[] getList(String raceListString){
        return raceListString.split(",");
    }
}
