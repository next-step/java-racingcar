package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.RacingCarGame;
import kr.co.techmoa.carracing.service.CarMoveService;

import java.util.Scanner;

public class InputView {

    public RacingCarGame view() {

        RacingCarGame racingCarGame = new RacingCarGame();

        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        racingCarGame.setCarNum(scanner.nextInt());

        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner scanner1 = new Scanner(System.in);
        racingCarGame.setTryNumber(scanner1.nextInt());

        CarMoveService carMoveService = new CarMoveService();
        return carMoveService.move(racingCarGame);
    }
}
