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
    public static ArrayList<RacingCar> creatCar(int carNum,String[] carNameList, int loopNum){

        ArrayList<RacingCar> carList = new ArrayList<RacingCar>();;

        if(carNum != carNameList.length){
            throw new IllegalArgumentException("입력한 차량 대수와 차량명 개수가 다릅니다.");
        }

        for (int i=0; i<carNum ;i++){
            // 차량명 길이 체크
            checkValid(carNameList[i]);
            ArrayList<Integer> randomList = creatRandom(loopNum);

            carList.add(new RacingCar(carNameList[i],countDrive(randomList),randomList));
        }

        return carList;
    }

    /**
     * 차량명 길이 체크
     * @param carName
     */
    private static void checkValid(String carName) {
        if(carName.length()> THRESHOLD){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과 하였습니다.");
        }
    }

    /**
     *  RacingCar 생성
     */
    public static ArrayList<Integer> creatRandom(int loopNum){
        ArrayList<Integer> randomList = new ArrayList<Integer>();

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
    public static int randomValue(){
        Random random = new Random();
        return random.nextInt(10);
    }

    /**
     * 4보다 큰값 Count
     */
    private static int countDrive(ArrayList<Integer> randomList){

        ArrayList<Integer> list = (ArrayList<Integer>) randomList.stream()
                .filter(item -> item >= CONDITION_VAL)
                .collect(Collectors.toList());

        return list.size();
    }

    public static int maxStep(ArrayList<RacingCar> carList){

        int maxNum = ZERO;

        for(RacingCar car: carList){
            maxNum = car.maxStep(maxNum);
        }

        return maxNum;
    }

    public static ArrayList<RacingCar> championList(ArrayList<RacingCar> carList, int maxCount){

        return (ArrayList<RacingCar>) carList.stream()
                .filter(item -> item.checkChampion(maxCount))
                .collect(Collectors.toList());
    }


    public static String combineName(ArrayList<RacingCar> champions){

        return champions.stream()
                .map(RacingCar::carName)
                .collect(Collectors.joining(", "));
    }

}
