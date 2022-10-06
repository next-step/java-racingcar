package game.view;

import game.controller.dto.CarDto;
import game.controller.dto.CarsDto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_SYMBOL = "-";
    private static final String OUTPUT_START_MESSAGE = "실행결과";
    private static final String OUTPUT_WINNER_SEPARATOR = ", ";
    private static final String OUTPUT_FINAL_MESSAGE = "가 최종 우승했습니다.";


    private OutputView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void printOutputStart() {
        System.out.println();
        System.out.println(OUTPUT_START_MESSAGE);
    }

    public static void printOutputBody(CarsDto carsDto) {
        for (CarDto carDto : carsDto.getCarList()) {
            System.out.println(getStringForOutput(carDto));
        }
        System.out.println();
    }

    private static String getStringForOutput(CarDto carDto) {
        return String.format("%s : %s", carDto.getCarName(), OUTPUT_SYMBOL.repeat(carDto.getPosition()));
    }

    public static void printOutputResult(CarsDto cars) {
        List<String> winners = cars.getLocatedHighPositionCars().stream()
                .map(CarDto::getCarName)
                .collect(Collectors.toList());
        System.out.println(String.join(OUTPUT_WINNER_SEPARATOR, winners) + OUTPUT_FINAL_MESSAGE);
    }

}
