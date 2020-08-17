package racing.core;

import java.util.Objects;
import java.util.stream.IntStream;

public class TrackInfo {

    public String track;

    public TrackInfo(int position) {
        this.track = drawTrack(position);
    }

    private String drawTrack(int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .reduce("", String::concat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackInfo trackInfo = (TrackInfo) o;
        return track.equals(trackInfo.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(track);
    }

    @Override
    public String toString() {
        return track;
    }
}
