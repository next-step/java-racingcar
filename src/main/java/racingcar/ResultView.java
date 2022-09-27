package racingcar;

import java.util.List;

public class ResultView {
    public static void main(String[] args) {
        System.out.println("자동차 수를 입력하세요.");
        int numberOfCar = new InputView().getNumberOfCar();
        System.out.println("이동횟수를 입력하세요.");
        int carMovingNum = new InputView().getCarMovingNum();
        RacingCar racingCar = new RacingCar(numberOfCar);
        List<String> carStatus;
        for (int i = 0; i < carMovingNum; i++){
            carStatus = racingCar.carMoving();
            for (int j = 0; j < numberOfCar; j++){
                System.out.println(carStatus.get(j));
            }
            System.out.println();
        }
    }
}
