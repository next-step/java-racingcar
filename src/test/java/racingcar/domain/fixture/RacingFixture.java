package racingcar.domain.fixture;

import racingcar.domain.Record;
import racingcar.domain.Records;

import java.util.ArrayList;
import java.util.List;

public class RacingFixture {

    public static List<Records> 자동차_경주_기록_목록 = new ArrayList<>();

    public static Records 첫번째_라운드_기록 = new Records();
    public static Records 두번째_라운드_기록 = new Records();
    public static Records 세번째_라운드_기록 = new Records();

    static {
        첫번째_라운드_기록.save(new Record(1, "pobi"));
        첫번째_라운드_기록.save(new Record(0, "jason"));
        첫번째_라운드_기록.save(new Record(1, "jobi"));

        두번째_라운드_기록.save(new Record(2, "pobi"));
        두번째_라운드_기록.save(new Record(1, "jason"));
        두번째_라운드_기록.save(new Record(1, "jobi"));

        세번째_라운드_기록.save(new Record(3, "pobi"));
        세번째_라운드_기록.save(new Record(2, "jason"));
        세번째_라운드_기록.save(new Record(2, "jobi"));

        자동차_경주_기록_목록.add(첫번째_라운드_기록);
        자동차_경주_기록_목록.add(두번째_라운드_기록);
        자동차_경주_기록_목록.add(세번째_라운드_기록);
    }
}