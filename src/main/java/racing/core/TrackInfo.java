package racing.core;

import java.util.Objects;
import java.util.stream.IntStream;

public class TrackInfo {

    private int position;

    public TrackInfo(int position) {
        this.position = position;
    }

    public String getTrack() {
        return IntStream.range(0, position)
                .mapToObj(position -> "-")
                .reduce("", String::concat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackInfo trackInfo = (TrackInfo) o;
        return position == trackInfo.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
