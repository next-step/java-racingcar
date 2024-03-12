package racingcar.step4.view.print;

import racingcar.step4.domain.Location;
import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.service.dto.RacingResultDto;
import racingcar.step4.utils.ConstUtils;

public class VisualizeRacePrintView {

    private final String printDelimiter;

    public VisualizeRacePrintView(String printDelimiter) {
        this.printDelimiter = printDelimiter;
    }

    public void printRacingResult(RacingResultDto racingResult) {
        for (RoundResultDto roundResult : racingResult.getRoundResults()) {
            printRoundResult(roundResult);
            System.out.println();
        }

        printWinners(racingResult);
    }

    private void printRoundResult(RoundResultDto roundResult) {
        for (ParticipantResultDto participantResult : roundResult.getParticipantResults()) {
            System.out.println(participantResult.getName() + " : " + printDelimiter.repeat(participantResult.getCurrentLocation()));
        }
    }

    private void printWinners(RacingResultDto racingResultDto) {
        String winners = String.join(ConstUtils.NAME_JOINING_DELIMITER, racingResultDto.getWinners());

        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
