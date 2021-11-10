package step4.view;

import step4.domain.dto.CarDto;
import step4.domain.dto.CarsDto;
import step4.domain.dto.GameHistoryDto;
import step4.domain.dto.Winners;
import step4.service.dto.GameInformation;
import step4.vo.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final GameHistoryDto gameHistoryDto;
    private final GameInformation gameInformation;

    private ResultView(GameHistoryDto gameHistoryDto, GameInformation gameInformation) {
        this.gameHistoryDto = gameHistoryDto;
        this.gameInformation = gameInformation;
    }

    public static ResultView from(GameHistoryDto gameHistoryDto, GameInformation gameInformation) {
        return new ResultView(gameHistoryDto, gameInformation);
    }

    public void view() {
        System.out.println("실행 결과");
        printHistory();
        printWinner();
    }

    private void printWinner() {
        Winners winners = gameHistoryDto.getWinners();
        System.out.println(getWinnerView(winners) + "가 최종 우승 했습니다.");
    }

    private String getWinnerView(Winners winners) {
        return winners.getWinners().getNames().stream()
                .map(Name::getValue)
                .collect(Collectors.joining(","));
    }

    private void printHistory() {
        List<CarsDto> history = gameHistoryDto.getHistory();

        for (CarsDto carsDto : history) {
            printCars(carsDto);
        }
    }

    private void printCars(CarsDto carsDto) {
        for (CarDto car : carsDto.getCarDtos()) {
            String positionView = getPositionView(car);
            System.out.println(car.getName().getValue() + " : " + positionView);
        }
        System.out.println();
    }

    private String getPositionView(CarDto car) {
        Integer now = car.getPosition().getNow();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < now; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
