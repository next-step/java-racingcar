package racing_winner.utils;

public class RacingUtils {

    public static final int INPUT_VALUE_RULE = 0;
    public static final int INPUT_STRING_LENGTH_RULE = 5;

    public static void checkInputValue(int round, String cars){
        if(round <= INPUT_VALUE_RULE){
            throw new IllegalArgumentException("경주 횟수는 0 이상으로 입력되어야합니다.");
        }
        if(cars.length() == INPUT_VALUE_RULE){
            throw new IllegalArgumentException("자동차를 입력해주세요.");
        }
    }

    public static String[] splitCarArray(String cars){
        return cars.split(",");
    }

    public static void checkNameLength(String car){
        if(car.length() > INPUT_STRING_LENGTH_RULE){
            throw new IllegalArgumentException("경주 자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }


}
