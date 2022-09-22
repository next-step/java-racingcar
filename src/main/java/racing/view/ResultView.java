package racing.view;

import racing.dto.CarRaceDto;

public class ResultView {

    public void result(CarRaceDto carRaceDto) {
        carRaceDto.carRace().forEach(car -> {
            String strState = "-".repeat(car.position());
            System.out.println(strState);
        });
        System.out.println();
    }
}
