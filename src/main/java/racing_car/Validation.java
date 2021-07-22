package racing_car;


import java.util.Arrays;

public class Validation {
    private final int MIN_LENGTH =3;
    private  String operator[] = {"+","-","*","/"};
    public void nullCheck(String input){
        if (input == null || input.equals("") || input.equals(" ")){
            throw new IllegalArgumentException("입력 값이 null 입니다.");
        }
        split(input.split(" "));
    }
    public void split(String[] str){
        if (str.length<MIN_LENGTH){
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다.");
        }
        splitNullCheck(str);
    }
    public void splitNullCheck(String [] str){
        for (String s : str){
            if (s.equals("") || s.equals(null)){
                throw new IllegalArgumentException("숫자와 사칙 연산 사이 공백은 한 칸을 넘으면 안됩니다.");
            }
        }
    }
    public boolean arithmeticSymbolsCheck(String op){
        if (!(Arrays.asList(operator).contains(op))){
            return false;
        }
        return true;
    }
}
