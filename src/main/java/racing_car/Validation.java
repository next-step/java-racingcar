package racing_car;


public class Validation {
    public String[] nullCheck(String input){
        if (input == null || input.equals("")){
            throw new IllegalArgumentException("입력 값이 null 입니다.");
        }
        return input.split(" ");
    }
    public void split(String[] str){
        if (str.length<3){
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다");
        }
    }

}
