package racingcar.step4.domain;

import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.domain.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Round {

    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public Round(MoveStrategy moveStrategy, Names names) {
        this.moveStrategy = moveStrategy;
        this.cars = createParticipantsCar(names);
    }

    public RoundResultDto move() {
        cars.copyCars().forEach(Car::move);

        List<ParticipantResultDto> participantResult = cars.copyCars().stream()
                .map(Car::getParticipantResult)
                .collect(Collectors.toList());

        return new RoundResultDto(participantResult);
    }

    private Cars createParticipantsCar(Names names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names.copyNames()) {
            cars.add(new Car(name, moveStrategy));
        }

        return new Cars(cars);
    }
}
