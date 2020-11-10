package racingcar.step3.domain;

/**
 * Created : 2020-11-09 오전 8:25.
 * Developer : Seo.
 */
public class Record {
    private int bestRecord;
    private String winner;

    public Record(int bestRecord, String winner) {
        this.bestRecord = bestRecord;
        this.winner = winner;
    }

    public void record(Car car) {
        if (Integer.compare(bestRecord, car.getDistance()) == -1) {
            this.bestRecord = car.getDistance();
            this.winner = car.getName();
        }
        if (!winner.equals("") && !winner.contains(car.getName())
                && Integer.compare(bestRecord, car.getDistance()) == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.winner).append(", ").append(car.getName());
            this.winner = sb.toString();
        }
    }

    public String getWinner() {
        return this.winner;
    }
}
