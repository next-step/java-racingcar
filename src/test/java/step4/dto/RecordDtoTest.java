package step4.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Record Dto 테스트")
public class RecordDtoTest {

    @DisplayName("속성이 같으면 같은 객체인지 확인")
    @Test
    public void equals() {
        RecordDto dto = new RecordDto("1", 2);
        RecordDto otherDto = new RecordDto("1", 2);

        boolean result = dto.equals(otherDto);

        assertThat(result).isEqualTo(true);
    }
}