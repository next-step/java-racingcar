package race;

import java.util.List;

public class RacingController {
    public static int setCarCount() {
        System.out.println("자동차 대수는 몇 대인가요?");
        return Util.inputCar();
    }

    public static int setTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Util.inputTry();
    }

    public static List<Integer> setCarList(int carCount) {
        return Car.createCar(carCount);
    }

    public static void racing(int tryCount, List<Integer> carList) {
        System.out.println("실행 결과\n");

        for (int index = 0; index < tryCount; index++) {
            decideCarForward(carList.size());
            Car.printCar(carList);
            System.out.println();
        }
    }

    public static void decideCarForward(int carListSize) {
        for (int index = 0; index < carListSize; index++) {
            setForwardCount(index);
        }
    }

    public static void setForwardCount(int index) {
        if (Car.canForward(Util.getRandomNumber())) {
            Car.addForward(index);
        }
    }
}
