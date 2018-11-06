package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class RacingCarUtil {

    private static final int RANDOMBOUNDARY=10;
    private static final String SEPARATOR=",";

    //랜덤 변수 생성
    public static int createRandomValue(){
        return new Random().nextInt(RANDOMBOUNDARY);
    }

    //리스트 나누기
    public static String[] splitList(String List){
        return List.split(SEPARATOR);
    }

    //array 에서 List 로 변환
    public static List<Car> arrayToList(Car[] cars){
        List<Car> list = new ArrayList<Car>();
        for(int i=0;i<cars.length;i++){
            list.add(cars[i]);
        }
        return list;
    }
}
