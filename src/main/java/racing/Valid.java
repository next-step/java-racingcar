package racing;

import java.util.List;
import java.util.Optional;

public class Valid {

    private Valid(){
    }

    public static void checkEmptyOrBlank(String[] names) {
        for (String name : names) {
            isEmpty(name);
        }
    }

    public static void isEmpty(String inputName) {
        if (inputName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public static void timeGreaterThenZero(int inputTime){

        if (inputTime < 1) {
            throw new IllegalArgumentException("반복횟수는 0보다 커야합니다.");
        }
    }
    public static void sizeCompare(String[] carNames, int[] positions){

        if(carNames.length != positions.length){
            throw new IllegalArgumentException("이름 사이즈와 위치 사이즈가 일치 하지 않습니다.");
        }
    }

    public static void positionMinusCheck(int position) {
        if(position < 0){
            throw new IllegalArgumentException("position은 음수가 될 수 없습니다.");
        }
    }

    public static void positionsNullCheck(int[] positions) {

        if(positions == null){
            throw new IllegalArgumentException("position이 null입니다.");
        }

    }
    public static void carNamesNullCheck(String[] carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException("carName이 null입니다.");
        }
    }

}
