package racingcar.domain.fixture;

import racingcar.domain.CarName;
import racingcar.domain.Record;
import racingcar.domain.Records;

import java.util.ArrayList;
import java.util.List;

public class RecordsFixture {

    public static List<Records> 자동차_경주_기록_목록 = new ArrayList<>();
    public static final Records 첫번째_라운드_기록 = new Records();
    public static final Records 두번째_라운드_기록 = new Records();
    public static final Records 세번째_라운드_기록 = new Records();

    public static final String 최종_우승자 = "pobi";

    static {
        첫번째_라운드_기록.addRecord(new Record(1, new CarName("pobi")));
        첫번째_라운드_기록.addRecord(new Record(0, new CarName("crong")));
        첫번째_라운드_기록.addRecord(new Record(1, new CarName("honux")));

        두번째_라운드_기록.addRecord(new Record(2, new CarName("pobi")));
        두번째_라운드_기록.addRecord(new Record(0, new CarName("crong")));
        두번째_라운드_기록.addRecord(new Record(2, new CarName("honux")));

        세번째_라운드_기록.addRecord(new Record(3, new CarName("pobi")));
        세번째_라운드_기록.addRecord(new Record(1, new CarName("crong")));
        세번째_라운드_기록.addRecord(new Record(2, new CarName("honux")));

        자동차_경주_기록_목록.add(첫번째_라운드_기록);
        자동차_경주_기록_목록.add(두번째_라운드_기록);
        자동차_경주_기록_목록.add(세번째_라운드_기록);
    }
}
