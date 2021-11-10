package step4.service.dto;

import step4.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Name> winners;

    private Winners(List<Name> winners) {
        this.winners = winners;
    }

    public static Winners create(List<Name> names) {
        return new Winners(names);
    }

    @Override
    public String toString() {
        List<String> winnerStringList = winners.stream()
                .map(Name::toString)
                .collect(Collectors.toList());
        return String.join(",", winnerStringList);
    }
}
