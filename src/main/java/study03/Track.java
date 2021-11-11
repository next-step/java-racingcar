package study03;

public class Track {

    private final StringBuffer totalTrack;

    public Track(int trackLength) {
        totalTrack = new StringBuffer();

        for (int i = 0 ; i < trackLength ; i ++) {
            totalTrack.append('-');
        }
    }

    public String getTotalTrack() {
        return totalTrack.toString();
    }
}
