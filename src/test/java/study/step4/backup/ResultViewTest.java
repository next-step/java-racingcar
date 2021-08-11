package study.step4.backup;

public class ResultViewTest {

//  @DisplayName("Car Name Output Test")
//  @Test
//  public void carNameOutputTest() {
//
//    final int CAR_GAME_ROUND = 5;
//    final String CAR_NAME_SPLITER = ",";
//    final String userCarNameInput = "car1,car2,car3";
//
//    String[] userCarNameSplited = userCarNameInput.split(CAR_NAME_SPLITER);
//
//    RacingGame racingGame = new RacingGame(userCarNameSplited, CAR_GAME_ROUND);
//
//    ResultView resultView = new ResultView(racingGame.getCars());
//    Result result = resultView.getResult();
//
//    for (int i = 0; i < result.getRacingGameCars().size(); i++) {
//      System.out
//          .println(result.getRacingGameCars().get(i).getName() + " , " + userCarNameSplited[i]);
//      assertThat(result.getRacingGameCars().get(i).getName()).isEqualTo(userCarNameSplited[i]);
//    }
//  }
//
//  @DisplayName("Car Winner Output Test")
//  @Test
//  public void carWinnerOutputTest() {
//
//    final int CAR_GAME_ROUND = 5;
//    final String CAR_NAME_SPLITER = ",";
//    final String userCarNameInput = "car1,car2,car3";
//    final int[] carDistances = {1, 2, 3};
//    final int carWinnerDistance = carDistances[2];
//
//    String[] userCarNameSplited = userCarNameInput.split(CAR_NAME_SPLITER);
//
//    // game init
//    RacingGame racingGame = new RacingGame(userCarNameSplited, CAR_GAME_ROUND);
//    ResultView resultView = new ResultView(racingGame.getCars());
//
//    // game start and car move
//    Cars cars = racingGame.getCars();
//    for (int i = 0; i < cars.getRacingGameCars().size(); i++) {
//      cars.getRacingGameCars().get(i).setDistance(carDistances[i]);
//      resultView.printResult();
//    }
//
//    // print winner car
//    resultView.printWinner();
//
//    assertThat(resultView.getResult().getCarWinnerDistance()).isEqualTo(carWinnerDistance);
//
//  }
}
