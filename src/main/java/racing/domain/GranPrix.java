package racing.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class GranPrix {
    private Integer maxLaps;
    private Set<RaceMachine> raceMachines;
}
