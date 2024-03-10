package racingcar.step4.domain;

import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.domain.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Round(MoveStrategy moveStrategy, List<String> names) {
        this.moveStrategy = moveStrategy;
        this.cars = createParticipantsCar(names);
    }

    public RoundResultDto move() {
        List<ParticipantResultDto> participantResult = cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());

        return new RoundResultDto(participantResult);
    }

    private List<Car> createParticipantsCar(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            cars.add(new Car(names.get(i), moveStrategy));
        }

        return cars;
    }
}
