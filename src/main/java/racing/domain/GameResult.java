package racing.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameResult {

    public static final int MINIMUM_POSITION = 0;
    private final List<String> entryNames;
    private final List<List<Integer>> roundResuls = new ArrayList<>();
    private final Set<String> winners = new HashSet<>();

    public GameResult(List<String> entryNames) {
        this.entryNames = entryNames;
    }

    public int totalRound() {
        return roundResuls.size();
    }

    public List<Integer> valueOfRoundResult(int i) {
        return roundResuls.get(i);
    }

    public void addRound(List<Integer> currentRoundResult) {
        if(entryNames.size() != currentRoundResult.size()){
            throw new IllegalStateException("Not equal init  entryList and current entryList");
        }
        roundResuls.add(currentRoundResult);

        registerCurrentWinner(currentRoundResult);
    }

    private void registerCurrentWinner(List<Integer> currentRoundResult) {
        winners.clear();
        int winnerPosition = MINIMUM_POSITION;
        for (int i = MINIMUM_POSITION; i < currentRoundResult.size(); i++) {
            Integer position = currentRoundResult.get(i);
            if(winnerPosition <= position){
                winnerPosition = position;
                winners.add(entryNames.get(i));
            }
        }
    }

    public int totalEntryCar() {
        return entryNames.size();
    }

    public List<String> valueOfEntryList() {
        return entryNames;
    }

    public Set<String> valueOfWinnerSet() {
        return winners;
    }
}
