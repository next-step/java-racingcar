package step4.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"vita:'vita  :'","clean:'clean :'","hJang:'hJang :'"}, delimiter = ':')
    @DisplayName("참가자의 이름 Tag가 제대로 출력되는지 확인")
    void carNameTagTest(String entryName,String nameTag){
        Car car = Car.participateRacing(entryName, 0);
        String entryNameTag = car.getEntryNameTag();
        assertThat(entryNameTag).isEqualTo(nameTag);
    }
}