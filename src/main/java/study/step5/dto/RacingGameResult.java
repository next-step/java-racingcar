package study.step5.dto;

import study.step5.domain.Round;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {

    private final List<Round> rounds;
    private final List<String> champions;

    public RacingGameResult(List<Round> rounds, List<String> champions) {
        this.rounds = rounds;
        this.champions = champions;
    }

    public List<Round> getRounds(){
        return rounds;
    }

    public List<String> getChampions(){
        return new ArrayList<>(champions);
    }
}
