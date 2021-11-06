# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 구현 기능목록

### GameExecutor
Process를 실행하여 결과를 반환하는 객체
- 기능
  - [ ] 게임 실행하여 결과 반환

### CarFactory
경주에 사용할 자동차 생성객체
- 기능
- [ ] 자동차 대수에 맞추어 생성

### Cars
경주에 사용할 자동차들을 각각 전진을 실행시키는 객체
- 기능 
- [ ] 자동차들의 전진 진행
- [ ] 자동차들의 전진상태 전달

### Car
경주에 사용할 자동차
- 기능
- [ ] 전진 진행
- [ ] 전진상태 전달

### MoveValueGenerator
전진 값 생성기
- 기능
- [x] 전진할 값 랜덤생성

### MoveValidator
전진 조건 판단
- 기능 
- [ ] 전진조건 판단

### InputValidator 
입력한 값 검증 객체
- 기능
- [ ] 입력한 자동차 대수 검증
- [ ] 입력한 시도회수 검증

### InputValue
입력한 값 객체
- 기능
- [ ] 입력한 자동차 대수 반환 
- [ ] 입력한 시도회수 반환

### InputUtils
입력한 값을 InputValue로 변경
- 기능 
- [ ] 입력한 값을 InputValue로 변경

### ErrorUtils
에러메세지를 생성하는 객체 

### InputView
입력 받는 UI 객체
- 기능
- [ ] 값 입력받기

### ResultView
결과 반환 UI 객체
- 기능
- [ ] 결과 반환

### ErrorView
에러 메세지 반환 UI 객체
- 기능
- [ ] 에러메세지 반환