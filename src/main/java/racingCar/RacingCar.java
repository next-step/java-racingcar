package racingCar;

import java.util.Random;

public class RacingCar {


    private static final int randomBoundary=10;
    private static final int conditionBoundary=4;
    private static final String separator=",";
    private static final int initPosition=0;
    private static String resultList="";



    public static int createRandomValue(){
        return new Random().nextInt(randomBoundary);
    }

    public static int move(int randomValue) {
        int moveCount = 0;

        if (isgoing(randomValue)) {
           moveCount++;
        }

        return moveCount;

    }

    public static boolean isgoing(int condition) {
        return condition > conditionBoundary;
    }


    //자동차 이동시키기
    public static CarVO[] moveCar(CarVO[] cars) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].position += move(createRandomValue());
        }

        return cars;
    }

    //이동거리를 숫자 -> 문자로 변환시키기
    public static String showPosition(int distance) {
        String position = "";
        for (int i = 0; i < distance; i++) {
            position += '-';
        }
        return position;
    }

    //String에서 ','를 기준으로 자동차 꺼내기
    public static String[] splitCarList(String carList){
        return carList.split(separator);
    }

    public static CarVO[] createCarVO(String[] names){
        CarVO[] cars = new CarVO[names.length];
        int i=0;
        for(String name : names){
            cars[i] = new CarVO(name, initPosition);
            i++;
        }
        return cars;
    }

    public static String selectWinner(CarVO[] cars) {
        CarVO winnerCar = cars[0];
        CarVO tempCar = null;
        resultList +=winnerCar.getName();
        for (int i = 1; i < cars.length; i++) {
            tempCar = compare(winnerCar, cars[i]);
            winnerCar = tempCar;
        }
        return resultList;
    }

    public static CarVO compare(CarVO origin, CarVO car2) {
        //중복되는 값일 경우
        if (origin.getPosition() == car2.getPosition()) {
            resultList += ", " + car2.getName();
            return origin;
        }

        //비교대상이 더 큰경우
        if (origin.getPosition() < car2.getPosition()) {
            resultList = "" + car2.getName();
            return car2;
        }
        //원래값이 더 큰경우
        return origin;
    }

}
