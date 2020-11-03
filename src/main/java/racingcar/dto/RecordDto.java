package racingcar.dto;

public class RecordDto {
    private final String name;
    private final Integer position;

    public RecordDto(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof RecordDto)) {
            return false;
        }
        RecordDto otherDto = (RecordDto) otherObject;
        if (otherDto.name == null || otherDto.position == null) {
            return false;
        }
        return otherDto.name.equals(name) && otherDto.position.equals(position);
    }
}
