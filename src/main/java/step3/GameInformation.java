package step3;

public class GameInformation {

    private final Integer count;
    private final Integer time;

    private GameInformation(Integer count, Integer time) {
        this.count = count;
        this.time = time;
    }

    public static GameInformation create(UserInput userInput) {
        Integer count = Integer.parseInt(userInput.getCountStr());
        Integer time = Integer.parseInt(userInput.getTimeStr());
        return new GameInformation(count, time);
    }

    public static GameInformation create(Integer count, Integer time) {
        return new GameInformation(count, time);
    }

    public Integer getCount() {
        return count;
    }

    public Integer getTime() {
        return time;
    }
}
