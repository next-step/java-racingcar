package racing.core.dto;

import java.util.Objects;

public class TrackInfo {

    private String carName;
    private int position;

    public TrackInfo(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackInfo trackInfo = (TrackInfo) o;
        return position == trackInfo.position &&
                carName.equals(trackInfo.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
