package RacingGame;

import RacingGame.domain.Car;
import RacingGame.domain.Cars;
import RacingGame.domain.DefaultRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class RacingGameTest {

    @Test
    @DisplayName("randomvale 가 4일때 잘 이동하는지 확인")
    public void move(){

        //given
        Car car = new Car();

        //when
        car.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 4;
            }
        });

        //than
        assertThat(car.isAt()).isEqualTo(1);

    }

    @Test
    @DisplayName("randomvale 가 2일때 멈추는지")
    public void stop(){

        //given
        Car car = new Car();

        //when
        car.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 2;
            }
        });

        //than
        assertThat(car.isAt()).isEqualTo(0);

    }

    @Test
    @DisplayName("Car의 이름이 잘 초기화 되었는지 확")
    public void carNameInitial(){

        //given
        RacingGame racingGame = new RacingGame();
        String[] nameOfCars = new String[]{"yurim","some","hey"};

        //when
        racingGame.getInputValue(nameOfCars);
        racingGame.prepareGame();
        List<String> names = racingGame.getCarDtos().stream()
                .map(carDto -> carDto.getName())
                .collect(Collectors.toList());

        //than
        Assertions.assertThat(names).containsExactly("yurim","some","hey");

    }

    @Test
    @DisplayName("Car의 name이 5글자 초과했을때 IllegalStateException 발생하는지 확인")
    public void carNameLengthOver5ThrowException(){
        assertThatIllegalStateException().isThrownBy(() ->{
            Car car = new Car("over5words");
        });

    }

    @Test
    @DisplayName("공백인 문자열에 대해 오류 처리")
    public void emptyNameThrowsException(){
        assertThatIllegalStateException().isThrownBy(() ->{
            Car car = new Car("  ");
        });
    }

    @Test
    @DisplayName("가장 멀리간 maxLocation을 잘 구하는지 확인")
    public void maxLocation(){
        //given
        Car win = new Car("win");
        win.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 4;
            }
        });

        Car lose = new Car("lose");
        lose.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 0;
            }
        });

        //when
        Cars cars = new Cars();
        Integer maxLocation = cars.getMaxLocation(Arrays.asList(win, lose));


        //than
        assertThat(maxLocation).isEqualTo(1);

    }

    @Test
    @DisplayName("승자를 잘 가리는지 확인")
    public void winnerTest(){
        //given
        Car win = new Car("win");
        Car lose = new Car("lose");
        win.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 4;
            }
        });

        lose.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 1;
            }
        });


        //when
        Cars cars = new Cars(Arrays.asList(win,lose));
        RacingGame racingGame = new RacingGame(cars);
        List<String> result = racingGame.getWinners();


        //than
        assertThat(result.get(0)).isEqualTo("win");
        assertThat(result.size()).isEqualTo(1);
    }


    @Test
    @DisplayName("승자가 두명일때 두명 가리는지 확인")
    public void twoWinnerTest(){
        //given
        Car win = new Car("win");
        Car win2 = new Car("win2");
        Car lose = new Car("lose");
        win.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 4;
            }
        });

        win2.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 4;
            }
        });

        lose.move(new DefaultRule(){
            @Override
            protected int getRandomValue(){
                return 1;
            }
        });



        //when
        RacingGame racingGame = new RacingGame();
        List<Car> cars = Arrays.asList(win,win2,lose);
        Cars racingCars = new Cars(cars);
        List<String> winners = racingCars.getWinners();

        //than
        assertThat(winners.size()).isEqualTo(2);
    }

}