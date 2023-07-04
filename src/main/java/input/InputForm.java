package input;

public class InputForm {

    public static void enterCarName(String str) {
        if (str.isBlank()) throw new RuntimeException("입력값이 없습니다.");
    }



}
