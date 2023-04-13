package dto;

import java.util.List;

public class InputDto {
    public List<String> carNames;
    public int trySize = 0;

    public InputDto(List<String> carNames, int trySize) {
        this.carNames = carNames;
        this.trySize = trySize;
    }
}
