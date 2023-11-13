package racing;


import static racing.InputView.inputData;
import static racing.InputView.inputNumberOfCar;
import static racing.InputView.inputRacingCount;
import static racing.ResultView.outputPrint;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Racing {

    private static final int RandomRange = 10;

    public static void Race() {
        //UI 및 Input값 받기
        startRacing(createCarList(inputNumberOfCar()),inputRacingCount());

    }

    //횟수당 레이싱 시작 메서드
    public static void startRacing(List<Car> carList, int inputRacingCount) {

        System.out.println(carList.size());
        System.out.println(carList.get(0).getDistance());
        System.out.println(inputRacingCount);
        for (int i = 0; i < inputRacingCount; i++) {
            outputPrint(carList);
            reStartRacing(carList);
        }
    }

    //횟수당 전진을 하는 것에 대한 메서드
    public static List<Car> reStartRacing(List<Car> carList) {
        for (Car car : carList) {
            car.setDistance(addCount(car.getDistance()));
        }
        return carList;
    }

    public static int addCount(int distance) {
        if (checkRandomData()) {
            return distance + 1;
        }
        return distance;
    }

    //랜덤값을 통한 전진여부 메서드
    public static boolean checkRandomData() {
        Random random = new Random();
        int randomData = random.nextInt(RandomRange);

        if (randomData >= 4) {
            return true;
        }
        return false;
    }

    //Car 대수 만큼 객체 리스트 생성
    public static List<Car> createCarList(int inputNumberOfCar) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < inputNumberOfCar; i++) {
            carList.add(new Car());
        }

        return carList;
    }

    public static void main(String[] args) {
        Race();
    }
}