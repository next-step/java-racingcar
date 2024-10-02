package racingcar.view;

import racingcar.service.RacingCarService;

public class InputView {
    private static final RacingCarService racingCarService = new RacingCarService();

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int NumberOfCars = racingCarService.EnterNumberOfCars();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int NumberOfMoves = racingCarService.EnterNumberOfMoves();
    }
}
