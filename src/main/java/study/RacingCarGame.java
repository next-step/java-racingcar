package study;

import java.util.*;
import java.util.stream.Collectors;

import static study.RacingCar.CONDITION_VAL;

public class RacingCarGame {

    public static final int ZERO = 0;

    public static final int THRESHOLD = 5;


    /**
     *  RacingCar 생성
     */
    public static ArrayList<RacingCar> creatCar(String carText,String carNames, String stepText){
        int carNum = ZERO;
        int loopNum = ZERO;

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();;

        String[] carNameList = carNames.split(",");

        carNum = _checkValue(carText);
        loopNum = _checkValue(stepText);

        if(carNum != carNameList.length){
            throw new IllegalArgumentException("입력한 차량 대수와 차량명 개수가 다릅니다.");
        }

        for (int i=0; i<carNum ;i++){
            // 차량명 길이 체크
            _checkValid(carNameList[i]);
            ArrayList<Double> randomList = creatRandom(loopNum);
            carList.add(new RacingCar(carNameList[i],countDrive(randomList),loopNum,randomList));
        }

        return carList;
    }

    /**
     * 차량명 길이 체크
     * @param carName
     */
    private static void _checkValid(String carName) {
        if(carName.length()> THRESHOLD){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과 하였습니다.");
        }
    }

    /**
     *  RacingCar 생성
     */
    public static ArrayList<Double> creatRandom(int loopNum){
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
    public static int countDrive(ArrayList<Double> randomList){

        ArrayList<Double> list = (ArrayList<Double>) randomList.stream()
                .filter(item -> item >= CONDITION_VAL)
                .collect(Collectors.toList());

        return list.size();
    }

    public static int maxStep(ArrayList<RacingCar> carList){

        int maxNum = carList
                .stream()
                .mapToInt(car -> car.getDrive())
                .max().orElseThrow(NoSuchElementException::new);

        return maxNum;
    }

    public static ArrayList<RacingCar> championList(ArrayList<RacingCar> carList, int maxCount){

        return (ArrayList<RacingCar>) carList.stream()
                .filter(item -> item.getDrive() == maxCount)
                .collect(Collectors.toList());
    }


    public static String combineName(ArrayList<RacingCar> champions){

        return champions.stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(", "));
    }

}
