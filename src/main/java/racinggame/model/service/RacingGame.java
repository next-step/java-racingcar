package racinggame.model.service;

import java.util.List;
import racinggame.model.domain.CarDTO;

public interface RacingGame {

  /**
   * 지정된 횟수만큼 게임 진행
   * <p>
   * racingCarList에 있는 racingCar들을 임의로 이동시킨다.
   * <p>
   * 진행 시 time --
   *
   * @return racingCarList 반환
   */
  List<CarDTO> play();

  /**
   * 자동차 경주의 우승자 반환<br/>
   * <p>
   * 반환 시점에 가장 멀리간 자동차를 출력한다.
   * @return 우승자 목록
   */
  List<CarDTO> getWinnerList();

  /**
   * 게임의 종료 여부 확인
   * <p>
   * time이 0이 될 경우 게임 종료
   *
   * @return boolean, 게임 종료 여부
   */
  boolean isNotEnd();
}
