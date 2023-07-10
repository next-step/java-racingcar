package racing.model;

import java.util.List;
import java.util.Objects;

public class RoundResultDto {
    private List<CarVO> roundResultDto;

    public RoundResultDto(List<CarVO> roundResultDto) {
        this.roundResultDto = roundResultDto;
    }

    public List<CarVO> getRoundResultDto() {
        return roundResultDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundResultDto that = (RoundResultDto) o;
        return Objects.equals(roundResultDto, that.roundResultDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundResultDto);
    }
}
