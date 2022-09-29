package carRacing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingHistory {
    private final List<Record> recordList = new ArrayList<>();

    public List<Record> getRecordList(int round) {
        return recordList
                .stream()
                .filter(vo->vo.getRound() == round)
                .collect(Collectors.toList());
    }

    public void doRecord(int round, List<Car> carList){
        for(Car car : carList){
            recordList.add(new Record(round, car.getName(), car.getPosition()));
        }
    }


    public int getLastRound(){
        return recordList
                .stream()
                .map(Record::getRound)
                .max(Comparator.comparing(round -> round))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Record> getWinnerRecordList() {
        int maxPosition = getMaxCarPosition();
        int lastRound = getLastRound();
        return recordList
                .stream()
                .filter(vo -> vo.getPosition() == maxPosition)
                .filter(vo -> vo.getRound() == lastRound)
                .collect(Collectors.toList());
    }

    private int getMaxCarPosition() {
        return recordList
                .stream()
                .map(Record::getPosition)
                .max(Comparator.comparing(position -> position))
                .orElseThrow(NoSuchElementException::new);
    }

}
