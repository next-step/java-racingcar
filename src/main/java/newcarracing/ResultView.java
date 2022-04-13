package newcarracing;

import java.util.List;

public class ResultView {

    private static final String WINNERS_DELIMITER = ", ";

    private ResultView() {}

    public static void printRacingCarsRoutes(List<RacingCar> cars) {
        cars.forEach(car -> System.out.println(car.createRacingCarRoute(car)));
    }

    public static void printWinners(List<RacingCar> cars) {
        System.out.println(createCommentForPrintingWinners(cars));
    }

    public static String createCommentForPrintingWinners(List<RacingCar> cars) {
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
}
