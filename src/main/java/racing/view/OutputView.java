package racing.view;

import racing.dto.RacingResultDto;

import java.util.List;

public class OutputView {

    public OutputView() {
        this.printGuidance();
    }

    private void printGuidance() {
        System.out.println("실행 결과");
    }

    public void printRacingResult(RacingResultDto racingResultDto) {
        List<Integer> racingPositions = racingResultDto.calculateRacingResult();
        racingPositions.forEach(position -> this.outputCarPosition(position));
        System.out.println();
    }

    private void outputCarPosition(Integer racingPosition) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < racingPosition; i++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder);
    }
}
