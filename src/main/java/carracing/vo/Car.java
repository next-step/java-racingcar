package carracing.vo;

import carracing.util.RandomUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Car {

    private final String RACING_RESULT_MARK = "-";

    private int carCount;
    private int tryCount;

    private List<String> racingResult;

    public void initializeRacingResult() {
        this.racingResult = Stream.generate(String::new).limit(this.carCount).collect(Collectors.toList());
    }

    public List<String> getRacingResult() {
        return this.racingResult;
    }

    public int getTryCount() {
        return this.carCount;
    }

    public void racing() {
        this.racingResult = this.racingResult.stream()
                .map(this::go)
                .collect(Collectors.toList());
    }

    public String go(String result) {
        if (RandomUtil.forward())
            result += RACING_RESULT_MARK;

        return result;
    }

    public void createCar(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }
}
