package racingcar;

import java.util.List;

public class ResultView {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        System.out.println("자동차 수를 입력하세요.");
        int numberOfCar = inputView.getNumberOfCar();
        System.out.println("이동횟수를 입력하세요.");
        int carMovingNum = inputView.getCarMovingNum();
        RacingCar racingCar = new RacingCar(numberOfCar);
        List<String> carStatus;
        for (int i = 0; i < carMovingNum; i++) {
            carStatus = racingCar.carMoving();
            System.out.println(carStatus);
        }
    }
}
