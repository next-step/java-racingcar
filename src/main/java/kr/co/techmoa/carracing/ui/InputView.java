package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.RacingCarGame;
import kr.co.techmoa.carracing.service.CarMoveService;

import java.util.Scanner;

public class InputView {

    public RacingCarGame view() {

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carNum = scanner.nextInt();

        System.out.println("자동차 이름은 어떻게 되나요?");
        Scanner scanner1 = new Scanner(System.in);
        String carName = scanner1.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner2 = new Scanner(System.in);
        int tryNum = scanner2.nextInt();

        return new CarMoveService().move(
                RacingCarGame.builder()
                .carNum(carNum)
                .carNames(carName)
                .tryNumber(tryNum)
                .build());
    }
}
