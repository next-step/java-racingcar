package study.racingcar.view;

import study.racingcar.domain.Car;
import study.racingcar.domain.Cars;
import study.racingcar.dto.ResponseDto;

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

    private static void printInitResult(){
        System.out.println();
        System.out.println(RESPONSE_MESSAGE_RESULT);
    }

    private static void printRoundResult(List<Cars> resultCars) {
        for (Cars resultCar : resultCars) {
            printCarResult(resultCar);
        }
    }

    private static void printCarResult(Cars resultCar) {
        for (Car car : resultCar.getResult()) {
            System.out.println(car.getName() + SPLIT_RESULT_MESSAGE + printLocation(car.getLocation()));
        }
        System.out.println();
    }

    private static String printLocation(int position){
        String location = "";
        for(int i = START_LOCATION; i < position; i++){
            location += MOVE_CHARACTER;
        }
        return location;
    }

    private static void printWinners(List<Car> cars) {
        String winners = cars.stream()
                                .map(Car::getName)
                                .collect(Collectors.joining(SEPARATOR + WHITE_SPACE));
        System.out.println(winners + RESPONSE_MESSAGE_SUFFIX_WINNERS);
    }

    public static void printResult(ResponseDto responseDto){
        printInitResult();
        printRoundResult(responseDto.getResultCars());
        printWinners(responseDto.getResultWinner());
    }
}
