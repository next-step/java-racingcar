import domain.RacingCar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameManagementTest {
    @Test
    @DisplayName("자동차 대회 게임 생섣 테스트 - 이름 추가")
    void createRacingCarGameManagementTest_WithNames() {
        //given
        int numberOfCars = 3;
        int numberOfGames = 6;
        MockRandomNumberGenerator generator = new MockRandomNumberGenerator(3);
        String[] testNames = new String[]{"pobi", "crong", "honux"};

        //when
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(testNames, numberOfGames, generator);

        //then
        Assertions.assertThat(carGameManagement.getGames()).isEqualTo(numberOfGames);
        Assertions.assertThat(carGameManagement.getCars()).hasSize(numberOfCars);
        List<RacingCar> cars = carGameManagement.getCars();
        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(cars.get(i).getStatus()).isEqualTo(0);
            Assertions.assertThat(cars.get(i).getName()).isEqualTo(testNames[i]);
        }
    }

    @Test
    @DisplayName("전진 테스트")
    void carMoveCarsTest() {
        //given
        int[] moves = new int[]{1, 4, 9};
        RacingCar car = new RacingCar("pobi");

        //when
        for (int move : moves) {
            car.move(move);
        }

        //then
        Assertions.assertThat(car.getStatus()).isEqualTo(2);
        Assertions.assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("게임 시작 테스트")
    void startGameTest() {
        //given
        int numberOfGames = 6;
        MockRandomNumberGenerator generator = new MockRandomNumberGenerator(5);
        String[] testNames = new String[]{"pobi", "crong", "honux"};
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(testNames, numberOfGames, generator);


        //when
        carGameManagement.start();

        //then
        Assertions.assertThat(carGameManagement.getGames()).isEqualTo(0);
        Assertions.assertThat(carGameManagement.getCars()).hasSize(testNames.length);
        List<RacingCar> cars = carGameManagement.getCars();
        for (int i = 0; i < 3; i++) {
            int move = cars.get(i).getStatus();
            String name = cars.get(i).getName();
            System.out.println(move);
            Assertions.assertThat(move).isEqualTo(6);
            Assertions.assertThat(name).isEqualTo(testNames[i]);
        }
    }

    @Test
    @DisplayName("우승자 테스트")
    void getWinnersTest() {
        //given
        int numberOfGames = 6;
        String[] testNames = new String[]{"pobi", "crong", "honux"};
        ArrayList<RacingCar> list = new ArrayList<>();
        list.add(new RacingCar(1, testNames[0]));
        list.add(new RacingCar(3, testNames[1]));
        list.add(new RacingCar(5, testNames[2]));
        RacingCarGameManagement carGameManagement = new RacingCarGameManagement(testNames, numberOfGames, new MockRandomNumberGenerator(5));

        //when
        List<String> winner = carGameManagement.findWinner(list);

        //then

        Assertions.assertThat(winner).hasSameElementsAs(List.of("honux"));
    }
}
