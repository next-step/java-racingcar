package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Participants;

class ParticipantsTest {

    @CsvSource(value = {"para,parb,parc,pard:4", "pobia,pobib:2"}, delimiter = ':')
    @ParameterizedTest(name = "[{arguments}] 입력값에 따라, 참가자들이 생성된다.")
    void joinTest(String input, int result) throws Exception {
        Participants participants = Participants.join(input);
        List<String> participantsNames = getNamesByReflection(participants);

        assertThat(participantsNames).hasSize(result);
    }


    @ValueSource(strings = {"para,parb,parc,pard,pare"})
    @ParameterizedTest(name = "Participants 생성후 ready()를 호출하면, 입력 순서와 동일한 이름을 가진 자동차 목록이 반환된다.")
    void readyTest(String input) throws NoSuchFieldException, IllegalAccessException {
        Participants participants = Participants.join(input);

        List<Car> readyOfCars = participants.ready();
        String[] inputOfNameArray = input.split(",");

        for (int i = 0; i < readyOfCars.size(); i++) {
            Car car = readyOfCars.get(i);
            String carNameByReflection = getCarNameByReflection(car);

            assertThat(carNameByReflection).isEqualTo(inputOfNameArray[i]);
        }


    }


    @SuppressWarnings("unchecked")
    private List<String> getNamesByReflection(Participants participants)
        throws NoSuchFieldException, IllegalAccessException {
        Field namesField = Participants.class.getDeclaredField("names");
        namesField.setAccessible(true);

        return (List<String>) namesField.get(participants);
    }

    private String getCarNameByReflection(Car car)
        throws NoSuchFieldException, IllegalAccessException {

        Field positionField = Car.class.getDeclaredField("name");
        positionField.setAccessible(true);

        return (String) positionField.get(car);
    }
}