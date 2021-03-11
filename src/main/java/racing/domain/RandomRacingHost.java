package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RandomRacingHost implements RacingHost {
    @Override
    public Racing holdRacing(List<String> participants, int round) {
        List<Car> carList = participants.stream()
                                        .map(s -> new Car(new RandomMovement(), s))
                                        .collect(Collectors.toList());

        return new Racing(carList, round);
    }
}
