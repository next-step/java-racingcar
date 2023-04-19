package racing.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameResult {

    public static final int MINIMUM_POSITION = 0;
    private final List<String> entryNameList;
    private final List<List<Integer>> roundResultList = new ArrayList<>();
    private final Set<String> winnerSet = new HashSet<>();

    public GameResult(List<String> entryNameList) {
        this.entryNameList = entryNameList;
    }

    public int totalRound() {
        return roundResultList.size();
    }

    public List<Integer> valueOfRoundResult(int i) {
        return roundResultList.get(i);
    }

    public void addRound(List<Integer> currentRoundResult) {
        if(entryNameList.size() != currentRoundResult.size()){
            throw new IllegalStateException("Not equal init  entryList and current entryList");
        }
        roundResultList.add(currentRoundResult);

        registerCurrentWinner(currentRoundResult);
    }

    private void registerCurrentWinner(List<Integer> currentRoundResult) {
        winnerSet.clear();
        int winnerPosition = MINIMUM_POSITION;
        for (int i = MINIMUM_POSITION; i < currentRoundResult.size(); i++) {
            Integer position = currentRoundResult.get(i);
            if(winnerPosition <= position){
                winnerPosition = position;
                winnerSet.add(entryNameList.get(i));
            }
        }
    }

    public int totalEntryCar() {
        return entryNameList.size();
    }

    public List<String> valueOfEntryList() {
        return entryNameList;
    }

    public Set<String> valueOfWinnerSet() {
        return winnerSet;
    }
}
