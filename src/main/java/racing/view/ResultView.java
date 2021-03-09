package racing.view;

import racing.model.RacingCarDto;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {

    public ResultView() {
        System.out.println("\n실행 결과");
    }

    public void turnResultView(List<RacingCarDto> movedCarList) {
        movedCarList.forEach(this::drawPosition);
        System.out.println();
    }

    public void drawPosition(RacingCarDto racingCarDto) {
        System.out.print(racingCarDto.getRacingCarName() + " : ");
        String position = "-";
        System.out.print(position.repeat(racingCarDto.getPosition()));
        System.out.println();
    }

    public void drawWinner(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }
}

