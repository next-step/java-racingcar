package racingcar.domain;

public class Winners {
    private Names names = new Names();
    private Distance distance = new Distance();

    public Names getNames() {
        return names;
    }

    public Distance getDistance() {
        return distance;
    }

    public Winners(Records records) {
        for (Record record : records) {
            updateWinner(record);
        }
    }

    private void updateWinner(Record record) {
        if (distance.getDistance() < record.getDistance()) {
            names.clear();
            names.add(record.getName());
            distance = new Distance(record.getDistance());
            return;
        }
        if (distance.getDistance() == record.getDistance()) {
            names.add(record.getName());
        }
    }
}
