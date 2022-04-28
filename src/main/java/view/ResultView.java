package view;

import dto.CarWinnerDto;
import model.CarName;
import model.RoundHistory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String PRINT_RESULT = "실행 결과";
    private static final String PRINT_POSITION = "-";
    private static final String CAR_NAME_POSITION_SEPARATOR = " : ";
    private static final String CAR_NAME_COLLECTORS_JOINING = ", ";
    private static final String WINNER_CAR_NAME_APPEND_TEXT = "가 최종 우승했습니다.";
    private static final StringBuilder stringBuilder = new StringBuilder();


    public static void printResult() {
        System.out.println(PRINT_RESULT);
    }

    public static void printResult(List<RoundHistory> moveHistories) {
        for (RoundHistory roundHistory : moveHistories) {
            printRoundHistory(roundHistory);
            printLineBreak();
        }
    }

    private static void printRoundHistory(RoundHistory roundHistory) {
        for (Map.Entry<CarName, Integer> history : roundHistory.getMoveHistory().entrySet()) {
            printExecuteResult(history.getKey(), history.getValue());
        }
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printExecuteResult(CarName carName, Integer position) {
        stringBuilder.append(carName.getName())
                .append(CAR_NAME_POSITION_SEPARATOR)
                .append(printPosition(position));
        System.out.println(stringBuilder);

        stringBuilder.setLength(0);
    }

    private static String printPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            stringBuilder.append(PRINT_POSITION);
        }

        return stringBuilder.toString();
    }

    public static void printWinnerCars(List<CarWinnerDto> carWinnerDto) {
        List<CarName> carNames = toCarNameList(carWinnerDto);
        String winnerCarNames = carNames.stream().map(CarName::getName).collect(Collectors.joining(CAR_NAME_COLLECTORS_JOINING));
        stringBuilder.append(winnerCarNames);
        stringBuilder.append(WINNER_CAR_NAME_APPEND_TEXT);
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
    }

    private static List<CarName> toCarNameList(List<CarWinnerDto> carWinnerDtos) {
        return carWinnerDtos.stream().map(CarWinnerDto::getCarName).collect(Collectors.toList());
    }
}
