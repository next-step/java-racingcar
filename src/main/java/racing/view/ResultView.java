package racing.view;

import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.dto.CarDTO;
import racing.domain.dto.RacingResultDTO;
import racing.domain.dto.ResultRacingsDTO;

public class ResultView {

    public void racingPrint(ResultRacingsDTO resultRacingsDTO, int cycle) {
        int round = 0;
        while (cycle > 0) {
            RacingResultDTO racing = resultRacingsDTO.getResultsRacings().get(round);
            for (CarDTO car : racing.getCarResult()) {
                System.out.print(car.getName() + ":");
                movePrint(car);
            }
            round++;
            cycle--;
            endCycle();
        }
    }

    private void movePrint(CarDTO car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void endCycle() {
        System.out.println();
    }

    public void winnerPrint(Cars winner) {
        System.out.println("우승자 발표!");
        for (Car car : winner.getItems()) {
            System.out.println(car.getName());
        }
    }
}
