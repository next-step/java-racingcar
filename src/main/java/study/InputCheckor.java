package study;

public class InputCheckor {



    public InputCheckor(String input){
        checkEmpty(input);
        checkOperator(input);
    }

    // null값 또는 "" 값 확
    void checkEmpty(String input){
        if(input == null || input ==""){
            throw new IllegalArgumentException("It's empty");
        }
    }

    //잘못된 값 확인
    void checkOperator(String input){

        String[] splited = input.split(" ");
        for(String str : splited){
            if(str.matches("[^0-9^\\*\\-\\+\\/\\s]")){
                throw new IllegalArgumentException("It's not operation");
            }
        }
    }


}
