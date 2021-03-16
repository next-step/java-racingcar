package step4.domain.request;

public class Participants {

    private int ZERO = 0;
    private String[] participants;

    public static Participants from(String[] participants) {
        return new Participants(participants);
    }

    private Participants(String[] participants) {
        if (isNullOrSizeLessThanZero(participants))
            throw new IllegalArgumentException("null 또는 사이즈가 0인 문자열이 들어왔습니다.");
        this.participants = participants;
    }

    private boolean isNullOrSizeLessThanZero(String[] participants) {
        return (isNull(participants) || isSizeLessThanZero(participants));
    }

    private boolean isNull(String[] participants) {
        return participants == null;
    }

    private boolean isSizeLessThanZero(String[] participants) {
        return participants.length <= ZERO;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getParticipantsLength() {
        return participants.length;
    }

}
