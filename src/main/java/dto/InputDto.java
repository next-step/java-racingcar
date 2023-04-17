package dto;

import java.util.List;

public class InputDto {
    private final List<String> carNames;
    private int trySize = 0;

    public InputDto(List<String> carNames, int trySize) {
        this.carNames = carNames;
        this.trySize = trySize;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTrySize() {
        return trySize;
    }
}
