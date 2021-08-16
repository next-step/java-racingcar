package kr.co.techmoa.carracing.ui.dto;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.service.RacingResults;

import java.util.List;

public class OutputDTO {

    private List<RacingResults> results;

    public OutputDTO(List<RacingResults> results) {
        this.results = results;
    }

    public List<RacingResults> getResults() {
        return results;
    }

}
