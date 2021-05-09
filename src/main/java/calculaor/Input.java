package calculaor;

import java.util.concurrent.ExecutionException;

public class Input {
    private final String splitValue = " ";

    // 빈값 (null 값 or " ") 판단하기
    public Boolean checkBlank(String blankValue) {
        if (blankValue.equals(" ") || blankValue == null) {
        }
        return true;
    }

    //  input값 " "기준으로 split하기
    public String[] splitter(String input) {
        return input.split(splitValue);
    }

    public static void main(String[] args) {
        Input input = new Input();
        String test = "2 + 3";
        String[] re = input.splitter(test);
        for (int i = 0; i < re.length; i++){
            System.out.println(re[i]);
        }
    }


    // 빈값 예외 처리
}