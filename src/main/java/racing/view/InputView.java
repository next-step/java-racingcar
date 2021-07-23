package racing.view;

import racing.RacingCar;

import java.util.Scanner;

public class InputView {
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer carNum = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer count = sc.nextInt();
        RacingCar racingCar = new RacingCar();
        racingCar.racing(carNum, count);
    }
}
