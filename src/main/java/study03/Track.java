package study03;

public class Track {

    private final StringBuffer totalTrack;

    public Track(int length) {
        totalTrack = new StringBuffer();

        for (int i = 0 ; i < length ; i ++) {
            totalTrack.append('-');
        }
    }

    public String getTotalTrack() {
        return totalTrack.toString();
    }
}
