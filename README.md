# 🚀 4단계 - 자동차 경주(우승자)

- 구현할 기능 목록 단위 추가
- commit 단위는 정리한 기능 목록 단위로 추가할 것!!

## 기능 요구사항
- [x] 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가
- [x] Car 구현
  - [x] move 구현: random4이상시 움직임
  - [x] getDistance: 차의 움직인 거리 getter
  - [x] 이름: 5자 제한, 생성할때 부여, getter 필요, Lombok  `@getter` 처리
- [] Race 구현
  - [x] Race 생성자 : 자동차들 list 준비,
  - [x] 자동차 리스트 가져오기: `@getter` 처리
  - [x] Race runRound

- [x] Input 구현
  - [x] 자동차 이름 입력
    - [x] : validate: 5자 : 이미 Car 생성자에서 구현

- [ ] result 구현
  - [x] 자동차 이름과 함께 움직임 출력
  - [x] 최종 우승자 출력: 1명 이상 일 수 있음

## Check 사항
- [ ] 들여쓰기 1까지인지 확인
- [ ] 메서드가 15라인을 넘어가지 않도록 구현
  - [ ] ~~pmd 15 line 적용 시도~~
    - https://github.com/pmd/pmd/issues/2127#issue-527718378
    - Enforcing length limits with LoC("lines of code") is not very meaningful, could even be called a bad practice
    - **LoC로 길이 제한을 적용하는 것은 그다지 의미가 없으며, 심지어 나쁜 관행이라고 할 수도 있습니다**
  - [ ] NCSS 15 라인 설정 - PMD Custom Rule apply

- [ ] 단일 책임 원칙으로 메서드가 되어 있는지 확인
- [ ] 모든 로직에 단위 테스트 구현 - UI 제외
- [ ] UI를 `InputView`, `ResultView`로 분리