package racingCar.step5.view;

import racingCar.step5.domain.dto.CarDto;
import racingCar.step5.domain.dto.RaceResult;
import racingCar.step5.domain.dto.WinnerDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ConsoleResultView implements ResultView{
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String STATE_PRINT_FORMAT = "-";
    private static final String CHAMPION_CAR_NAME_SEPARATOR = ",";
    private static final String CHAMPION_PRINT_FORMAT = "%s가 최종 우승했습니다.";

    public void showRaceResults(List<RaceResult> raceResults) {
        System.out.println(RESULT_MESSAGE);

        for (RaceResult raceResult : raceResults) {
            printCars(raceResult);
            endRace();
        }
    }

    private void printCars(RaceResult raceResult) {
        for (CarDto car : raceResult.getCars()) {
            printCarPosition(car);
        }
    }

    private void printCarPosition(CarDto car) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s : ", car.getName()));
        sb.append(STATE_PRINT_FORMAT);

        for(int i = 0; i< car.getPosition(); i++){
            sb.append(STATE_PRINT_FORMAT);
        }
        System.out.println(sb.toString());
    }

    public void showRaceChampion(List<WinnerDto> winners) {
        List<String> names = carNamesFrom(winners);
        String championName = String.join(CHAMPION_CAR_NAME_SEPARATOR, names);
        System.out.format(CHAMPION_PRINT_FORMAT, championName);
    }

    private List<String> carNamesFrom(List<WinnerDto> winners){
        return winners.stream()
                .map(WinnerDto::getCarName)
                .collect(toList());
    }

    private void endRace() {
        System.out.println();
    }
}
