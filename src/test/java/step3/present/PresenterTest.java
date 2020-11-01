package step3.present;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.RacingCars;
import step3.model.RandomCommander;
import step3.view.RenderingView;

import static org.assertj.core.api.Assertions.assertThat;

public class PresenterTest {

    @DisplayName("참가 차량 댓수에 맞는 RacingCar 인스턴스 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 3, 6, 21})
    public void makeRacingCar(int participantCar) {
        //Given
        Presenter presenter = new Presenter(new RenderingView(), new RandomCommander());

        //When
        RacingCars result = presenter.createParticipantRacingCar(participantCar);

        //Then
        assertThat(result.size()).isEqualTo(participantCar);
    }


}
