package step3.study.dto;

import java.util.List;

public class ResponseRacingDTO {
    private final List<String> names;
    private final List<Integer> positions;

    public ResponseRacingDTO(List<String> names, List<Integer> positions) {
        this.names = names;
        this.positions = positions;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
