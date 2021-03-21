package carracing.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Setter
@Getter
public class Car {

    private final String RACING_RESULT_MARK = "-";

    private Integer carCount;
    private Integer tryCount;

    private List<String> racingResult;

    public void initializeRacingResult() {
        this.racingResult = Stream.generate(String::new).limit(this.carCount).collect(Collectors.toList());
    }
}
