package racing.domain;

import org.apache.commons.lang3.StringUtils;

public class RacingCarDto {
    private String carName;
    private String position;

    public RacingCarDto(String carName, int position) {
        this.carName = carName;
        this.position = StringUtils.repeat("&nbsp;&nbsp;", position);
    }

    public String getCarName() {
        return carName;
    }

    public String getPosition() {
        return position;
    }
}
