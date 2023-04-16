package racing;

public class ExceptionHandler {

    public static void illegalArgument(Integer number){
        if(number < 0 ){
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
