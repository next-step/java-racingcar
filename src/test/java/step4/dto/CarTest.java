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

    @ParameterizedTest
    @CsvSource(value = {"1:5:2","2:3:2","0:4:1"}, delimiter = ':')
    @DisplayName("주사위 값에 따라 차량이 제대로 이동하는지 확인")
    void carPositionDependingOntheDiceNumberTest(int initPosition, int diceNumber, int lastPosition){
        step5.dto.Car car = step5.dto.Car.participateRacing("TestC", initPosition);
        car.moveRound(diceNumber);

        assertThat(car.nowPosition()).isEqualTo(lastPosition);
    }
}