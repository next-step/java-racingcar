package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String MOVING = "-";
    private static final String COLON = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printNewLine(){
        System.out.println();
    }

    public static void drawPosition(Car car){
        StringBuilder builder = new StringBuilder();
        printPosition(builder, car.getPosition());
    }

    public static void printPositionList(List<Car> carList){
        for(Car car: carList) drawPosition(car);
    }

    public static void drawPositionWithName(Car car){
        StringBuilder builder = new StringBuilder(car.getName() + COLON);
        printPosition(builder, car.getPosition());
    }

    private static void printPosition(StringBuilder builder, int length){
        for(int i=0; i<length; i++){
            builder.append(MOVING);
        }
        System.out.println(builder);
    }

    public static void printPositionWithNameList(List<Car> carList){
        for(Car car: carList) drawPositionWithName(car);
    }

    public static void printWinner(List<Car> carList){
        List<String> winners = getWinnersName(carList);

        StringBuilder builder = new StringBuilder(String.join(",", winners));
        builder.append(WINNER_MESSAGE);
        System.out.println(builder);
    }

    private static int getWinnerPosition(List<Car> carList){
        return carList.stream()
                .mapToInt(car -> car.getPosition())
                .max().getAsInt();
    }

    public static List<String> getWinnersName(List<Car> carList){
        int maxVal = getWinnerPosition(carList);
        return carList.stream()
                .filter(car -> car.isWinner(maxVal))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
