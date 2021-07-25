package racing.view;

import racing.model.RacingModel;

import java.util.Scanner;

public class InputView {
    public void inputData(RacingModel racingModel) {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        Integer carSize = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Integer playCont = sc.nextInt();
        racingModel.settingGame(carSize, playCont);
    }
}
