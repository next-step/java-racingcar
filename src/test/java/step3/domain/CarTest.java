package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Card에 주입된 Strategy에 따라서 record가 예상되는 값을 반환해야 함")
    @ParameterizedTest(name = "{index} {displayName} / Strategy가 반환하는 값=\"{0}\"")
    @CsvSource(value = {"true,false,true:1,1,2", "false:0", "true:1", "true,true:1,2", "false,false:0,0"}, delimiter = ':')
    void recordByStrategy(String StaticValuesString, String expectRecordString) {
        List<Integer> expectedRecord = Arrays.stream(expectRecordString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        class StaticStrategy implements MovableStrategy {
            private final List<Boolean> staticValues = Arrays.stream(StaticValuesString.split(","))
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
            private int round = 0;
            @Override
            public boolean move() {
                boolean thisRoundResult = this.staticValues.get(round);
                round++;
                return thisRoundResult;
            }
        }
        MovableStrategy staticStrategy = new StaticStrategy();
        int round = expectedRecord.size();

        Car car = new Car("kero", staticStrategy);
        for (int i = 0; i < round; i++) {
            car.move();
        }

        List<Integer> record = car.getRecord().getRecord();
        assertThat(record).isEqualTo(expectedRecord);
    }
}
