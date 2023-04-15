package racingcar.domain.fixture;

import racingcar.domain.Name;
import racingcar.domain.Record;

import java.util.List;

public class RecordFixture {

    public static List<Record> 자동차_기록_목록 = List.of(
            new Record(1, new Name("pobi")),
            new Record(2, new Name("crong")),
            new Record(3, new Name("hyun"))
    );
}
