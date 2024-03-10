# 자동차 경주 🚗 🏁

## ✅ 구현 목록 : 체크 리스트

---

### `RacingController.class`

- [x] 유저의 입력값을 받아 메인 서비스(`RacingGame`)를 호출하여 결과값을 전달받아 출력해주는 매개체

### `RacingService.class`

- [x] 경주에 참가하는 자동차의 대수 만큼 Car 인스턴스 추가 (`joinCars()`)
- [x] 자동차의 움직임 메서드와 위치 기록 메서드를 호출 (`move()`, `record()`)

### 입출력 클래스

- [x] 입력 클래스 (`InputView.class`)
    - 자동차 대수를 입력
    - 움직임 회수 입력
    - 입력값이 숫자가 아니거나 0 이하의 값일 경우 재입력 요청
- [x] 출력 클래스 (`ResultView.class`)
    - 실행 결과를 출력

### `Car.class`

- [x] 점수를 가짐 (= 자동차의 위치)
- [x] move()를 호출하여 자동차의 움직임 여부를 결정
    - 이때 움직임을 결정하는 핵심 로직은 `전략 패턴` 사용 (`CarMovementStrategy.class`)

### 유틸

- [x] `RandomNumberGeneratorUtil.class` : 0 ~ 9 사이의 값을 반환

### 테스트 코드

- [x] `RacingGameTest.class`
- [x] `CarTest.class`

### 컨벤션

- [x] Java : Intellij idea Code Style java 적용
- [x] Commit : AngularJS Commit Message 사용

### 코드 규칙

- [x] else 예약어 사용 X
- [x] switch / case 사용 X