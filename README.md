# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## To-Do
* 패키지 생성 : view(InputView, ResultView), domain(CarFactory, Car, RacingGame, RacingMain), util(RandomUtil)
* Scanner를 이용한 자동차 이름 입력 - InputView
* Scanner를 이용한 시도 횟수 입력 - InputView
* Car 객체들을 관리하는 List 생성 (InputView에서 입력받은 자동차 이름 split) - CarFactory
* Car 객체 생성 (field : name(자동차 이름), position(현재 위치이자 전진 횟수)) - Car
* Car의 position, name 포장 - Position, Name 생성ggi
* 자동차 이름 길이 5 제한 - Car. 생성자 생성 단계에서 체크
* Random을 이용한 랜덤값 추출 - RandomUtil
* 랜덤 값이 4 이상인지를 기준으로 전진/정지 결정 - Car
* 전진일 경우 Car 객체의 location 값을 1 증가 - Car
* 경주 종료 후 우승자 찾기. Car를 담고 있는 리스트에서 position이 가장 큰 차의 이름 뽑아내기 - Winner
* 경주 결과 출력 - ResultView

## 5단계 피드백
* hashCode 오버라이딩 : 꼭 Position을 리턴해야 하는가
* NameTest에서 assertThatIllegalArgumentException 활용해보기
* Text Fixture의 개념
* 도메인에서 컨트롤러 파트 분리