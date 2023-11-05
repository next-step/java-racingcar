package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCarGame {

    public static final int ZERO = 0;


    /**
     *  RacingCar 생성
     */
    public static Map<String,RacingCar> creatCar(String carText, String loopText){
        int carNum = ZERO;
        int loopNum = ZERO;
        int drive = ZERO;
        int stop = ZERO;

        Map<String,RacingCar> carMapList = new HashMap<String,RacingCar>();

        carNum = checkValue(carText);
        loopNum = checkValue(loopText);

        for (int i=0; i<carNum ;i++){

            RacingCar car = new RacingCar();
            Map<Integer, Double> randomList = creatRandom(loopNum);
            drive = countDrive(randomList);
            stop = loopNum - drive;
            car.setDrive(drive);
            car.setStop(stop);
            car.setLoopCount(loopNum);
            car.setRandomList(randomList);
            carMapList.put("CarNo"+i, car);

        }

        return carMapList;
    }

    /**
     *  RacingCar 생성
     */
    public static Map<Integer, Double> creatRandom(int loopNum){
        Map<Integer, Double> randomList = new HashMap<Integer, Double>();

        for (int i=0; i<loopNum ;i++){
            randomList.put(i, randomValue());
        }

        return randomList;
    }


    /**
     * UI에서 입력 된 문자 숫자 여부 체크 및 숫자 변환
     * @param text
     * @return 숫자
     */
    public static int checkValue(String text){

        /*
        공백, null 일때 Exception 발생
        */
        if (text == null || text.isEmpty()){
            return ZERO;
        }

        /*
        정수형 숫자 여부 판단
         */
        if(text.contains(".")){
            throw new IllegalArgumentException("정수형 숫자가 아닙니다.");
        }

        try {
            return Integer.parseInt(text);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

    }

    /**
     * Random 숫자 생성
     * @return 0 ~ 9 자연수
     */
    public static double randomValue(){
        Random random = new Random();
        return random.nextInt(10);
    }

    /**
     * 4보다 큰값 Count
     */
    public static int countDrive(Map<Integer, Double> randomListMap){

        Map<Integer, Double> drivenMap = randomListMap.entrySet().stream()
                .filter(map -> map.getValue() >= 4)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return drivenMap.size();
    }

}
