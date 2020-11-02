package step4;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class RecordDto {
    private final String name;
    private final Integer record;

    public RecordDto(String name, Integer record) {
        this.name = name;
        this.record = record;
    }
}
