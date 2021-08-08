package racing_winner.utils;

public class CommonUtils {
    public static String[] splitInput(String str){
        if(str.length() == 0){
            throw new IllegalArgumentException("값을 입력해주세요");
        }
        return str.split(",");
    }
}
