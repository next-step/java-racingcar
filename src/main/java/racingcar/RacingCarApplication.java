package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.view.ResultView;

import java.util.Scanner;

public class RacingCarApplication {

    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RacingCarController racingCarController = new RacingCarController();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String racingCarNames = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int numberOfTime = scanner.nextInt();

        RacingCarResponseDto racingCarResponseDto = racingCarController
                .startRacingGame(new RacingCarRequestDto(racingCarNames, numberOfTime));

        resultView.print(racingCarResponseDto.getRacingScores());
        resultView.printWinner(racingCarResponseDto.getWinners());
    }
}
