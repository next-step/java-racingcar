package study;

public class InputCheckor {



    public InputCheckor(){

    }

    // null값 또는 "" 값 확
    void checkEmpty(String input){
        if(input == null || input ==""){
            throw new IllegalArgumentException("It's empty");
        }
    }

    //잘못된 값 확인
    void checkOperator(int size){
        if(size !=0){
            throw new IllegalArgumentException("It's not operation");
        }
    }


}
