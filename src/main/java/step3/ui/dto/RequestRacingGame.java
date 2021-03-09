package step3.ui.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestRacingGame that = (RequestRacingGame) o;
        return getParticipants() == that.getParticipants() && getAttemptCount() == that.getAttemptCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParticipants(), getAttemptCount());
    }
}
