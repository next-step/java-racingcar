package dto;

import racing.domain.GameReport;
import racing.domain.RoundReport;

import java.util.List;
import java.util.Objects;

public class Response {

    private final GameReport gameReport;

    public Response(final GameReport gameReport) {
        this.gameReport = Objects.requireNonNull(gameReport);
    }

    public static Response of(GameReport gameReport) {
        return new Response(gameReport);
    }

    public List<RoundReport> getRoundReports() {
        return gameReport.getRoundReports();
    }

    public List<String> getWinners() {
        return gameReport.winner();
    }
}
