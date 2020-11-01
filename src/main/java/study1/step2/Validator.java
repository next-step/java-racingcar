package study1.step2;

public class Validator {
    void validate(String input){
        if(inputNullCheck(input) || inputValueCheck(input)){
            throw new IllegalArgumentException("입력값 확인해주세요");
        }
    }

    String[] getInputList(String input){
        return input.split(" ");
    }

    private boolean inputNullCheck(String input){
        return input == null;
    }
    private boolean inputValueCheck(String input) {
        return "".equals(input.trim());
    }
}
