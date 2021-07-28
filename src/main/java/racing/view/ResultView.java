package racing.view;

import racing.model.RacingCar;

import java.util.List;

public class ResultView {
    private static final String RACING_CAR_GAME_RESULT_OUTPUT_MESSAGE = "실행 결과";
    private static final String RACING_WINNERS_OUTPUT_MESSAGE = "이(가) 최종 우승했습니다.";
    private static final String RACING_CAR_POSITION_MARK = "-";
    private static final String ONE_BLANK_SPACE= " ";
    private static final String COLON = ":";
    private static final String COMMA = ",";

    public void printRacingCarGameResultOutputMessage() {
        System.out.println(RACING_CAR_GAME_RESULT_OUTPUT_MESSAGE);
    }

    public void printRacingCarsStatus(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            StringBuilder racingCarStatusMessage = new StringBuilder();
            racingCarStatusMessage.append(racingCar.getName());
            racingCarStatusMessage.append(ONE_BLANK_SPACE);
            racingCarStatusMessage.append(COLON);
            racingCarStatusMessage.append(ONE_BLANK_SPACE);
            racingCarStatusMessage.append(getRacingCarPositionMark(racingCar.getPosition()));
            System.out.println(racingCarStatusMessage);
        }
        printNewLine();
    }

    private String getRacingCarPositionMark(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(RACING_CAR_POSITION_MARK);
        }
        return sb.toString();
    }

    public void printRacingWinners(List<RacingCar> winners) {
        StringBuilder racingWinnersOutputMessage = new StringBuilder();
        for (RacingCar winner : winners) {
            racingWinnersOutputMessage.append(winner.getName());
            racingWinnersOutputMessage.append(COMMA);
            racingWinnersOutputMessage.append(ONE_BLANK_SPACE);
        }
        racingWinnersOutputMessage.deleteCharAt(racingWinnersOutputMessage.length() - 1);
        racingWinnersOutputMessage.deleteCharAt(racingWinnersOutputMessage.length() - 1);
        racingWinnersOutputMessage.append(RACING_WINNERS_OUTPUT_MESSAGE);
        System.out.println(racingWinnersOutputMessage);
    }

    private void printNewLine() {
        System.out.println();
    }
}
