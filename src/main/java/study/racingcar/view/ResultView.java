package study.racingcar.view;

import study.racingcar.model.Car;
import study.racingcar.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESPONSE_MESSAGE_SUFFIX_WINNERS = "가 최종 우승했습니다.";
    private static final String RESPONSE_MESSAGE_RESULT = "실행 결과";
    private static final String SPLIT_RESULT_MESSAGE = " : ";
    private static final String MOVE_CHARACTER = "-";
    private static final int START_LOCATION = 0;
    private static final String SEPARATOR = ",";
    private static final String WHITE_SPACE = " ";

    public static void printInitResult(){
        System.out.println();
        System.out.println(RESPONSE_MESSAGE_RESULT);
    }

    public static void printResult(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getName() + SPLIT_RESULT_MESSAGE + printLocation(car.getLocation()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        String winners = cars.stream()
                                .map(Car::getName)
                                .collect(Collectors.joining(SEPARATOR + WHITE_SPACE));
        System.out.println(winners + RESPONSE_MESSAGE_SUFFIX_WINNERS);
    }

    private static String printLocation(int position){
        String location = "";
        for(int i = START_LOCATION; i < position; i++){
            location += MOVE_CHARACTER;
        }
        return location;
    }
}
