package racingcar.dto;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarState;
import racingcar.domain.RacingCarStates;
import racingcar.domain.RacingFleet;

import java.util.ArrayList;
import java.util.List;

public final class RacingCarStatesDTO {
    private final List<RacingCarStateDTO> carStates;

    private RacingCarStatesDTO(List<RacingCarStateDTO> carStates) {
        this.carStates = carStates;
    }

    public static RacingCarStatesDTO valueOf(RacingFleet fleet) {
        List<RacingCar> racingCars = fleet.getRacingCars();
        List<RacingCarStateDTO> carStates = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            carStates.add(RacingCarStateDTO.valueOf(racingCar));
        }
        return new RacingCarStatesDTO(carStates);
    }

    public static RacingCarStatesDTO valueOf(RacingCarStates states) {
        List<RacingCarStateDTO> carStates = new ArrayList<>();
        for (RacingCarState state : states.value()) {
            carStates.add(RacingCarStateDTO.valueOf(state));
        }
        return new RacingCarStatesDTO(carStates);
    }

    public List<RacingCarStateDTO> getCarStates() {
        return this.carStates;
    }
}
