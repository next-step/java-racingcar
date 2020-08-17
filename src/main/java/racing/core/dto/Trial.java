package racing.core.dto;

import java.util.List;
import java.util.Objects;

public class Trial {

    private List<TrackInfo> tracks;

    public Trial(List<TrackInfo> tracks) {
        this.tracks = tracks;
    }

    public int getNumberOfTrack() {
        return tracks.size();
    }

    @Override
    public String toString() {
        return tracks.stream()
                .map(trackInfo -> trackInfo.getTrackInfo() + "\n")
                .reduce("", String::concat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return tracks.equals(trial.tracks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tracks);
    }
}
