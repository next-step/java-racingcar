package racingcar.step3.domain;

/**
 * Created : 2020-11-09 오전 8:25.
 * Developer : Seo.
 */
public class Record {
    private int bestRecord = 0;
    private String winner = "";

    public void record(Car car) {
        if (Integer.compare(bestRecord, car.getDistance()) == -1) {
            this.bestRecord = car.getDistance();
            this.winner = car.getName();
        }
        if (!winner.contains(car.getName())
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
