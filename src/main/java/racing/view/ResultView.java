package racing.view;

import racing.model.RacingCarDto;
import racing.model.RacingCarsDto;

import java.util.List;

public class ResultView {


    public ResultView() {
        System.out.println("\n실행 결과");
    }

    public void turnResultView(List<RacingCarDto> movedCarList) {
        for (RacingCarDto racingCarDto : movedCarList) {
            drawPosition(racingCarDto);
        }
        System.out.println();
    }

    public void drawPosition(RacingCarDto racingCarDto) {
        System.out.print(racingCarDto.getRacingCarName() + " : ");
        System.out.print(racingCarDto.getPosition().moveDistance());
        System.out.println();
    }

    public void finish(List<String> winners, List<RacingCarsDto> recode) {
        for (RacingCarsDto racingCarsDto : recode) {
            turnResultView(racingCarsDto.getCarList());
        }
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}

