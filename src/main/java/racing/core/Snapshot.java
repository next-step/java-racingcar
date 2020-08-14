package racing.core;

import java.util.Objects;
import java.util.stream.IntStream;

public class Snapshot {

    public String track;

    public Snapshot(int position) {
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
        Snapshot snapshot = (Snapshot) o;
        return track.equals(snapshot.track);
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
