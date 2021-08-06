package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.RacingCarGame;
import kr.co.techmoa.carracing.service.CarMoveService;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public RacingCarGame view() {

        return new CarMoveService().move(
                RacingCarGame.builder()
                .carNum(getCarSu())
                .carNames(getCarNames())
                .tryNumber(getRounds())
                .build());
    }

    public static int getCarSu() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        if(SCANNER.hasNextLine()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }

    public static String getCarNames() {
        System.out.println("자동차 이름은 어떻게 되나요?");
        if(SCANNER.hasNextLine()) {
            return SCANNER.next();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        if(SCANNER.hasNextLine()) {
            return SCANNER.nextInt();
        }
        throw new IllegalArgumentException("입력 값이 없습니다.");
    }
}
