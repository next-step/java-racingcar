# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 참고자료
- 주석보다는 `@DisplayName` 이용하기
- 커밋 규칙
  - AngularJS 진영의 커밋 방식
  - https://gist.github.com/stephenparish/9941e89d80e2bc58a153
  - https://jissi.tistory.com/10
- 안쓰는 코드는 삭제하고 복원이 필요하다면 VCS 의 도움을 받아서 이전 버전코드 기록을 참고한다. 
- ENUM 으로 역할 분리하고 반복되는 조건 분기처리하기
  - [else 예약어를 쓰지 않는다](https://tecoble.techcourse.co.kr/post/2020-07-29-dont-use-else/) 
  - [Anti-OOP : if 를 피하고 싶어서](http://redutan.github.io/2016/03/31/anti-oop-if)
  - [Enum 활용기](https://techblog.woowahan.com/2527/)
- 객체생활체조원칙
  - https://jamie95.tistory.com/99
  - indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 for 문 안에 if문이 있으면 들여쓰기는 2이다.
    힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [static method만을 가지는 utility class는 private 생성자를 가지도록 구현한다.](https://www.slipp.net/questions/360)
- [매직넘버 상수화](https://hoonmaro.tistory.com/44)
- 자바 코드 컨벤션
  - https://google.github.io/styleguide/javaguide.html
  - https://myeonguni.tistory.com/1596
- 인터페이스 기반 전략패턴
  - Random하게 이동하는 전략 (운영)
  - 무조건 전진하는 전략 (테스트)
  - 등 전략을 바꿔가면서 테스트 코드에 활용할 수 있다.

## 기억하기
- 1차적으로 도메인 로직 테스트
  - 도메인 객체를 추출하고 이에 대해서만 우선 테스트 해보자
- 

## Step03 자동자 경주 구현 기능 목록

- [x] 사용자로부터 자동차의 수, 이동 횟수 입력받기
- [x] 사용자의 입력값에 따라 자동차 생성하기
- [x] 자동차 이동하기
    - [x] 랜덤숫자가 4이상일때 전진하기
- [x] 자동차 이동결과 출력하기

## Step04 추가 요구사항

- [x] 자동차 이름 입력받기 - InputView
  - [x] 쉼표 구분해서 자동차 생성 - initicateCar
  - [x] 자동차 이름 검증 후, 저장하기 - RacingCar
  - [ ] 자동차 이름 5글자 제한 에러처리
- [x] 자동차 전진상태 출력시 이름도 같이 출력 - ResultView
- [ ] 경주 완료 후, 우승자 출력하기 (우승자는 1명 이상이 될 수 있음) - RacingResult

# 지우고 다시해보기
## Step03 + Step04 플로우 정리 
1. 사용자는 몇 대의 자동차로 몇 번의 이동을 할지 입력
  - 사용자로부터 자동차의 개수, 이동횟수를 입력받기
  - 쉼표로 구분해서 자동차 이름 입력받기
  - 이름은 1자 이상 5자 이하이다.
2. 사용자가 입력한 자동차의 개수만큼 자동차가 생성된다. 
3. 사용자 입력한 이동횟수만큼 0-9의 랜덤값이 생성된다. 이 랜덤값이 4 이상일 경우만 자동차는 전진한다. 
4. 자동차의 위치 (상태)가 화면에 출력된다.
  - 자동차 출력시 이름도 같이 출력하기
  - 우승자 출력하기

## Step03 + Step04 구현할 기능목록 정리
- [x] 사용자 입력 화면 생성
  - [x] 질문 출력하기
  - [x] 자동차 이름 입력받기
  - [x] 시도할 횟수 입력받기
  - [x] 입력받은 답변들 다른 곳에서 꺼내쓸 수 있도록 저장하기
- [ ] 입력받은 자동차 이름 숫자 만큼 자동차 생성하기
  - [ ] 자동차 이름 쉽표로 구분하기
  - [ ] 이름 1자 이상 5자 이하인지 유효성 검사하기
  - [ ] 랜덤값 생성 로직 만들기
  - [ ] 랜덤값에 따라서 전진, 멈춤 하도록 로직 구현하기
- [ ] 우승자 뽑는 로직 구현하기
- [ ] 자동차 경주 결과 화면 생성
  - [ ] 자동차의 이동결과 출력하기
  - [ ] 우승자 출력하기 (1명이상일 수 있음)
  
## 설계
- Controller
  - RacingMain
  - RacingGame
- Domain
  - Car
    - name
    - position
  - Cars : List<Car>
    - winnner 
- View
  - InputView
  - ResultView



## 프로그래밍 요구사항
- 모든 로직에 단위테스트 구현한다. UI 로직은 제외
- 자바 코드 컨벤션을 지키면서 프로그래밍을 한다. 
- else 예약어를 쓰지 않는다. 
- indent depth 는 2를 넘지 않는다. 
- 함수 또는 메서드의 길이가 15라인을 넘어가지 않도록 구현한다.

## 기능목록 및 commit 로그 요구사항
- readme에 구현할 기능목록 정리하기
- git 에 commit 할 때에는 위의 기능목록 정리한 단위로 하기
- commit message convention 지키기
  ```
  feat (feature)
  fix (bug fix)
  docs (documentation)
  style (formatting, missing semi colons, …)
  refactor
  test (when adding missing tests)
  chore (maintain)
  ```