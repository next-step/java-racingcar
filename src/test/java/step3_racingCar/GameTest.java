package step3_racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class GameTest {
    private Game game;
    private static final int TRYNUM = 3;
    private static final int CARNUM = 4;
    private ArrayList<Integer> inputs;
    MockedStatic<InputView> inputView;

    @BeforeEach
    void setUp(){
        inputs = new ArrayList<>();
        inputs.add(CARNUM);
        inputs.add(TRYNUM);

        inputView = mockStatic(InputView.class);
        when(InputView.input(Game.strs))
                .thenReturn(inputs);
        game = new Game();
        inputView.close();
    }

    @Test
    void createGame(){
        assertThat(game).extracting("tryNum")
                .containsOnly(TRYNUM);

        assertThat(game).extracting("racingCars")
                .hasOnlyElementsOfType(Cars.class);
    }

    /*
    질문: 정확하게 Game만의 기능을 테스트하려면 GameFactory도 마찬가지로 MockStatic으로 설정하고
    Cars와 car도 mock상태로 리턴한 다음에, verify로 racingCars의 tryForward()나 Result의 print 등이 호출되는지를 확인해야할것 같은데,
    mock로 설정시 Game에서 고유로 실행되는 로직이 조건문, System.out의 출력문뿐이어서 그렇게 진행하는 테스트의 의미가 있는지에 대한 의문이 듭니다.
    그렇다고 그냥 테스트를 진행하기에는 play()는 void 함수여서 무언가를 return해주는 값도 아닌지라... Mock을 안한다면 test를 해줄 방도를 찾기도 어렵습니다.
    여기서는 전부 mock로 설정해서 독립적인 테스트를 구성하는게 옳을까요?
    */
    @Test
    void playGame(){

        game.play();
    }

}
