package calculator;

import java.util.regex.Pattern;

public class Calculator {

    public Calculator() {
    }

    public int calculate(String express) {
        if (isBlank(express)) throw new IllegalArgumentException();
        return getResult(splitBlank(express));
    }

    private boolean isBlank(String express) {
        if (express == null) return true;
        if (express.equals(" ")) return true;
        if (express.contains("  ")) return true;
        return false;
    }

    private String[] splitBlank(String express) {
        return express.split(" ");
    }

    private int getResult(String[] data) {
        int sum = 0;
        for (int i = 0; i < data.length - 2; i += 2) {
            // 유효성 검사에서 연산자임을 이미 검증했다 가정하고 코딩을 시작
            if(data[i+1].equals("+")){
                sum += plus(Integer.parseInt(data[i]), Integer.parseInt(data[i+2]));
            }
            if(data[i+1].equals("-")){
                sum += minus(Integer.parseInt(data[i]), Integer.parseInt(data[i+2]));
            }
        }
        return sum;
    }

    private int plus(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }

    private int minus(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }


    // private boolean isPatternMatches(String express){
    // return !(Pattern.matches("^[0-9\\+\\-*/\\s=]*$", express));}

}
