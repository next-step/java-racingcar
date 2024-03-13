## TODO

- 사용자 입력(InputView)
    - [x] 자동차 대수를 입력한다 ("자동차 대수는 몇 대 인가요?")
    - [x] 몇번의 이동할 것인지 입력한다 ("시도할 회수는 몇 회인가요?")
    - [x] 입력 값이 1미만인 경우 IllegalArgumentException(Unchecked) 던진다
    - [x] 예외 발생한 경우 재입력 요청한다
- 랜덤값 (RandomUtil)
    - [x] 0 ~ 9 사이 값을 반환한다
- 자동차 (Car)
    - [x] <s>position 값을 가진다</s>
    - [x] <s>random 값이 4이상일 경우 position 을 1 증가 시킨다 (=전진시킨다)</s>
    - [x] position 값을 책임지는 Position 클래스를 생성한다
    - [x] random 값이 4미만일 경우 현재 position 유지한다
    - [x] random 값이 4이상일 경우 Postion의 move() 호출하여 position 값을 증가시킨다
    - [x] 현재 위치를 hyphen으로 변환한 문자열을 반환한다 --hyphenatePosition()
- 위치 (Position)
    - [x] position 상태값을 가진다
    - [x] move() 호출시 position 값을 1 증가 시킨다
    - [x] 현재 position 값을 hyphen으로 연결한 문자열을 변환한다 -- toString()
- RacingGame
    - [x] 참가하는 자동차 대수만큼 컬렉션에 Car 인스턴스를 추가한다 -- participate(..)
    - [x] 매턴 Car의 move() 호출한다 -- run()
- RacingRecord
    - [x] 매턴 자동차의 현재 위치(HYPHEN으로 연견될 문자열)를 기록한다
- 결과 출력 (ResultView)
    - [x] 실행 결과를 전달받아 출력한다

---

### 3단계 피드백 반영

- [x] 사용자 입력 유효성 검사 조건에 ONE 상수 제거
- [x] run() 실행시 RacingRecord 인스턴스 반환하여 View 전달하도록 변경
    - [x] Record 클래스(DTO) 추가
- [x] RacingGame 테스트 케이스 분리, 반환된 RacingRecord 결과로 처리하도록 변경
- [x] @FunctionalInterface 어노테이션 추가
- [x] carList -> cars 로 renaming

### 4단계 피드백 반영

- [x] RandomUtil 제거, RandomMove 기능 이동
- [x] Cars (일급 컬렉션) 추가
- [x] RacingGame에 Cars (일급 컬렉션) 적용
- [x] ResultView 상태값 추가

### 5단계 피드백 반영

Car 클래스

- [x] Car 멤버 필드 타입 생성자 추가
- [x] Position move() 호출시 불변 처리
- [x] 이동하지 않을 경우 참조 주소로 인한 이슈 해결

Name 클래스

- [x] 매직넘버 처리 -- MAX_LENGTH

RacingGame, RacingRecord, ResultView

- [x] View 영역 출력 형식 변경 고려하여 List\<Car\> winners 전달하도록 수정
- [x] ResultView는 List\<Car\> winners 상태값 가져와 처리하도록 수정



