package newcarracing;

import java.util.List;

public class ResultView {
    private static final String ROUTE = "-";
    private static final String NAME_AND_ROUTE_DELIMITER = " : ";
    private static final String WINNERS_DELIMITER = ", ";

    private ResultView() {}

    public static void printGameResult(List<RacingGameResult> racingGameResults) {
        System.out.println("실행 결과");
        for(RacingGameResult racingGameResult : racingGameResults) {
            printRacingCarsRoutes(racingGameResult.getRacingCars());
            System.out.println();
        }
        // 최종 결과 확인
        printWinners(racingGameResults.get(racingGameResults.size()-1).getWinners());
    }

    static void printRacingCarsRoutes(List<RacingCar> cars) {
        cars.forEach(car -> System.out.println(createRacingCarRoute(car)));
    }

    static void printWinners(List<RacingCar> cars) {
        System.out.println(createCommentForPrintingWinners(cars));
    }

    static String createCommentForPrintingWinners(List<RacingCar> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndex = cars.size() - 1;
        for(int i = 0; i <= lastIndex; i++) {
            stringBuilder.append(cars.get(i).getName());
            appendDelimiter(stringBuilder, i, lastIndex);
        }
        return stringBuilder.append("가 최종 우승했습니다.").toString();
    }

    private static void appendDelimiter(StringBuilder stringBuilder, int currentIndex, int lastIndex) {
        if(currentIndex < lastIndex) {
            stringBuilder.append(WINNERS_DELIMITER);
        }
    }

    static String createRacingCarRoute(RacingCar car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName()).append(NAME_AND_ROUTE_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(ROUTE);
        }
        return stringBuilder.toString();
    }
}
