package racingcar.domain.dto;

import org.apache.commons.lang3.StringUtils;

public class ResponseDto {
    private String name;
    private String position;

    public ResponseDto(String name, int position) {
        this.name = name;
        this.position = StringUtils.repeat("&nbsp;", position-1);
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
