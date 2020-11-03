package step4.dto;

public class RecordDto {
    private final String name;
    private final Integer record;

    public RecordDto(String name, Integer record) {
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public Integer getRecord() {
        return record;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof RecordDto)) {
            return false;
        }
        RecordDto otherDto = (RecordDto) otherObject;
        if (otherDto.name == null || otherDto.record == null) {
            return false;
        }
        return otherDto.name.equals(name) && otherDto.record.equals(record);
    }
}
