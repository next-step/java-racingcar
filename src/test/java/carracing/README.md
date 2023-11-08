## 기능 요구사항
- 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.

## TODO
### Step2 리뷰반영
- [x] Pattern 객체를 상수처리
- [x] 배열에서 컬렉션 API로 변경
- [x] Stream API 구현
- [x] 유효성 검증 일급객체 사용
- [x] 테스트 메서드 네이밍 및 DisplayName 수정

### Step3
- [x] 자동차를 N대 만큼 생성한다.
- [x] 자동차를 움직이게 한다.
- [x] 자동차를 랜덤값(0~9)만큼 움직일 수 있게한다.
- [x] 자동차가 랜덤값이 4이상일 때만 움직이게 한다.
- [x] 화면을 출력한다.
- [x] 화면에서 값을 입력한다.

### 리팩토링
- [x] InputView로 화면 입력을 구현한다.
- [x] ResultView로 화면 출력을 구현한다.

- [x] 문자열계산기를 책임사슬패턴으로 구현해본다.
- [X] 레이싱을 전략패턴으로 구현해본다.

---
# Step4
## Step3 리뷰반영 TODO
- NotNumberException -> NumberFormatException (자바표준 Exception으로 변경)
- RandomPoint 랜덤넘버 상수화
- TrackHistory를 dto로 생각하고 분리하기
    - CarRace에서 게임 횟수로 동작하게 하고 List<CarRaceResponse>로 쌓이게 구현
    - Clonable 제거

## 기능 요구사항
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.


## TODO
- inputView에서 이름목록 추출
- 자동차에 이름 필드 추가, 제한사항 5글자
- CarsResponse에 이름도 변환
- Track에서 우승자 확인하는 기능 추가
- CarRaseResponse에 우승자 필드 추가
- OutputView에서 우승자 필드 출력 추가

---
# Step5
## Step4 리뷰반영 TODO
- Track 클래스 리팩토링
  - 이동 전략은 Car의 Move
  - run, winners는 Cars로
- Position 클래스 래핑
- 우승자 구하는 코드 리팩토링

## TODO
- Response에는 값만 들어가고 화면 보여주는 로직은 OutputView로 분리
- InputView와 Request분리하기
