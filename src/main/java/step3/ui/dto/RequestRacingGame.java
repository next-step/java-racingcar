package step3.ui.dto;

/**
 * 레이스 요청 파라미터 관리 클래스
 */
public class RequestRacingGame {

    private final int participants;
    private final int attemptCount;

    public RequestRacingGame(int participants, int attemptCount) {
        this.participants = participants;
        this.attemptCount = attemptCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getParticipants() {
        return participants;
    }
}
