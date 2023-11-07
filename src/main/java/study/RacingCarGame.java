package study;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGame {

    public static final int ZERO = 0;
    public static final boolean VALID = true;
    public static final boolean INVALID = false;
    public static final int THRESHOLD = 5;


    /**
     *  RacingCar 생성
     */
    public static ArrayList<RacingCar> creatCar(String carText,String carNames, String stepText){
        int carNum = ZERO;
        int loopNum = ZERO;
        int drive = ZERO;
        //차량명 유효 체크
        boolean isValid = VALID;

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();;

        String[] carNameList = carNames.split(",");

        carNum = _checkValue(carText);
        loopNum = _checkValue(stepText);

        if(carNum != carNameList.length){
            throw new IllegalArgumentException("입력한 차량 대수와 차량명 개수가 다릅니다.");
        }

        for (int i=0; i<carNum ;i++){
            _checkValid(carNameList[i]);
            carList.add(new RacingCar(carNameList[i],drive,loopNum,_creatRandom(loopNum)));
        }

        return carList;
    }

    private static void _checkValid(String carName) {
        if(carName.length()> THRESHOLD){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과 하였습니다.");
        }
    }

    /**
     *  RacingCar 생성
     */
    private static ArrayList<Double> _creatRandom(int loopNum){
        ArrayList<Double> randomList = new ArrayList<Double>();

        for (int i=0; i<loopNum ;i++){
            randomList.add(randomValue());
        }

        return randomList;
    }


    /**
     * UI에서 입력 된 문자 숫자 여부 체크 및 숫자 변환
     * @param text
     * @return 숫자
     */
    private static int _checkValue(String text){

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
