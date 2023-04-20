package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutput implements Output {
    private static final String ONE_POSITION_MARK = "-";
    private static final String EXECUTION_HEADER = "\n실행 결과";
    private static final String ARE_WINNERS = "가 최종 우승했습니다.";

    @Override
    public void printPositions(Race race) {
        race.toCarDtoList().forEach(this::printPosition);
        printBlankLine();
    }

    @Override
    public void printExecutionHeader() {
        System.out.println(EXECUTION_HEADER);
    }

    @Override
    public void printWinner(Race race) {
        List<Car> winnerCars = race.getFirstPlace();
        System.out.println(carListToString(winnerCars) + ARE_WINNERS);
    }

    @Override
    public void printPosition(CarDto carDto) {
        System.out.println(carDto.getName() + " : " + ONE_POSITION_MARK.repeat(carDto.getPosition()));
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }

    private String carListToString(List<Car> cars) {
        return cars.stream()
                .map(car -> car.toDto().getName())
                .collect(Collectors.joining(", "));
    }
}
