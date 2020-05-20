package study.step3;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String UNDER_BAR_SYMBOL ="_";
    private static final String CAR_NAME_DELIMITER =" : ";
    private static final String CHAMPION_RESULT_MESSAGE ="가 최종 우승했습니다.";
    private static final int INIT_ZERO = 0;

    public static void racingResultPrint(List<Round> rounds) {
        for (Round round : rounds){
            carToString(round.getCars());
            System.out.println();
        }
    }

    private static void carToString(List<Car> cars) {
        for (Car car: cars){
            System.out.println(car.getCarName()+CAR_NAME_DELIMITER+convertToUnderBarSymbol(car.getCarPosition()));
        }
    }

   private static String convertToUnderBarSymbol(int pointInTimeCarPostion) {
        StringBuilder stringBuilder = new StringBuilder(UNDER_BAR_SYMBOL);
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
