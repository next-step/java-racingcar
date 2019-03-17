package racing.view;

import com.google.common.base.Strings;

public class RacingCarDto {
    private static final String WEB_BLANK = "&emsp;";
    private String carName;
    private int position;

    public RacingCarDto(String carName) {
        this.carName = carName;
    }

    public RacingCarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getWebPosition() {
        return Strings.repeat(WEB_BLANK, position);
    }

    public String getCarName() {
        return carName;
    }
}