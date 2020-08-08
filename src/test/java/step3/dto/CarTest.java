package step3.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.MoveCar;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1:'CAR1   |'","2:'CAR2   |'","3:'CAR3   |'"}, delimiter = ':')
    @DisplayName("참가자의 이름 Tag가 제대로 출력되는지 확인")
    void carNameTagTest(int entryNumber,String nameTag){
        Car car = Car.participateRacing(entryNumber,0);
        String entryNameTag = car.getEntryNameTag();
        assertThat(entryNameTag).isEqualTo(nameTag);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3","2:0:1","3:1:2"}, delimiter = ':')
    @DisplayName("차량이 제대로 이동했는지 확인")
    void carMovePositionTest(int entryNumber,int startPositionString, int endPosition){
        Car car = Car.participateRacing(entryNumber,startPositionString);
        car.movePosition();
        int nowPosition = car.nowPosition();
        assertThat(nowPosition).isEqualTo(endPosition);
    }
  
    @ParameterizedTest
    @CsvSource(value = {"1:2","2:1","3:0"}, delimiter = ':')
    @DisplayName("차량이 랜덤함수의 결과대로 이동했는지 확인")
    void carMovePosition2Test(int entryNumber,int startPositionString){
        Car car = Car.participateRacing(entryNumber,startPositionString);
        boolean moveCondition = MoveCar.moveCondition(car);

        if(moveCondition){
            assertThat(car.nowPosition()).isEqualTo(startPositionString+1);
        }else{
            assertThat(car.nowPosition()).isEqualTo(startPositionString);
        }

    }
}