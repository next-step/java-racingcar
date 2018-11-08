package racingCar.domain;


import java.util.Random;



public class RacingCarUtil {

    private static final int RANDOM_BOUNDARY=10;
    private static final String SEPARATOR=",";

    //랜덤 변수 생성
    public static int createRandomValue(){
        return new Random().nextInt(RANDOM_BOUNDARY);
    }

    //리스트 나누기
    public static String[] splitList(String List){
        return List.split(SEPARATOR);
    }

    public static String showPosition(int distance) {
        String position = "";
        for (int i = 0; i < distance; i++) {
            position += '-';
        }
        return position;
    }
}
