package game.racing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class TrackingLog {

    private String name;
    private List<Integer> log;

    public TrackingLog(String name) {
        this.name = name;
        log = new ArrayList<>();
    }

    public void add(int position) {
        log.add(position);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return log.size();
    }

    public int getPositionByTimes(int times) {
        return log.get(times);
    }
}
