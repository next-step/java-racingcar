package study.step5.view;

import study.step5.domain.Car;
import study.step5.dto.RacingGameResult;
import study.step5.domain.Round;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String UNDER_BAR_SYMBOL ="_";
    private static final String CAR_NAME_DELIMITER =" : ";
    private static final String CHAMPION_RESULT_MESSAGE ="가 최종 우승했습니다.";
    private static final int INIT_ZERO = 0;

    private ResultView() {
    }

    public static void racingResultPrint(RacingGameResult results) {
        List<Round> rounds = results.getRounds();
        for (Round round : rounds){
            carToString(round.getCars());
            System.out.println();
        }
        printChampion(results.getChampions());
    }

    private static void carToString(List<Car> cars) {
        for (Car car: cars){
            System.out.println(car.getCarName()+CAR_NAME_DELIMITER+convertToUnderBarSymbol(car.getCarPosition()));
        }
    }

   private static String convertToUnderBarSymbol(int pointInTimeCarPostion) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = INIT_ZERO; i < pointInTimeCarPostion; i++){
            stringBuilder.append(UNDER_BAR_SYMBOL);
        }
        return stringBuilder.toString();
    }

    public static void printChampion(List<String> champions) {
        String champion = convertListToString(champions);
        System.out.println(champion+CHAMPION_RESULT_MESSAGE);
    }

    private static String convertListToString(List<String> champions) {
        return champions.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
    }
}
