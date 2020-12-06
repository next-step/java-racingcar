package dto;

import racing.domain.GameReport;
import racing.domain.RoundReport;

import java.util.List;

public class Response {

    private final List<RoundReport> roundReports;

    public Response(final List<RoundReport> roundReports) {
        this.roundReports = roundReports;
    }

    public static Response of(GameReport gameReport) {
        return new Response(gameReport.getRoundReports());
    }

    public List<RoundReport> getRoundReports() {
        return roundReports;
    }
}
