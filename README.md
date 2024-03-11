# 자동차 경주 🚗 🏁

## ✅ 구현 목록 : 체크 리스트

❗ 가장 최신으로 업데이트된 기능은 **(<span style="color:red">New</span>)** 접미사가 포함됨

---

### `RacingController.class`

- [x] 유저의 입력값을 받아 메인 서비스(`RacingGame`)를 호출하여 결과값을 전달받아 출력해주는 매개체

### `RacingService.class`

- [x] 경주에 참가하는 자동차의 대수 만큼 Car 인스턴스 추가 (`joinCars()`)
- [x] 자동차의 움직임 메서드와 위치 기록 메서드를 호출 (`move()`, `record()`)

### 입출력 클래스

- [x] 입력 클래스 (`InputView.class`)
    - [x] 자동차 이름 입력
        - [x] 복수개의 자동차는 ','를 기준으로만 구분 가능 (**<span style="color:red">New</span>**)
        - [x] 자동차 1개의 이름은 5를 초과할 수 없음 (**<span style="color:red">New</span>**)
    - [x] 움직임 회수 입력
        - [x] 입력값이 숫자가 아니거나 0 이하의 값일 경우 재입력 요청
- [x] 출력 클래스 (`ResultView.class`)
    - [x] 전진하는 자동차를 출력할 때 이름을 같이 출력 (**<span style="color:red">New</span>**)
    - [x] 최종 우승자 이름을 출력 (**<span style="color:red">New</span>**)

### `Car.class`

- [x] 점수를 가짐 (= 자동차의 위치) (**<span style="color:red">New</span>**)
- [x] `Position.class`로 자동차의 위치를 저장
- [x] move()를 호출하여 자동차의 움직임 여부를 결정
    - 이때 움직임을 결정하는 핵심 로직은 `전략 패턴` 사용 (`CarMovementStrategy.class`)

### 테스트 코드

- [x] `RacingGameTest.class`
- [x] `CarTest.class`

### 컨벤션

- [x] Java : Intellij idea Code Style java 적용
- [x] Commit : AngularJS Commit Message 사용

### 코드 규칙

- [x] else 예약어 사용 X
- [x] switch / case 사용 X
- [x] index의 들여쓰기 depth는 1회까지 허용 (**<span style="color:red">New</span>**)
- [x] 함수(또는 메서드)의 길이가 15라인을 넘지 않도록 작성  (**<span style="color:red">New</span>**)