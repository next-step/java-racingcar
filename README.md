# 자동차 경주 게임

## 객체 목록

### 자동차 객체 기능 목록
- [ ] 자동차는 이름을 가질 수 있다. - Car
- [ ] 자동차 이름의 길이가 5글자를 넘으면 예외가 발생한다.  - Car
- [ ] 자동차의 초기위치는 0 이다. - Car
- [ ] 자동차의 현재 위치를 알 수 있다. - Car
- [ ] 자동차가 이동한다. - Car
- [ ] 자동차가 정지한다. - Car
- - -

### 경기장 객체 기능 목록
- [ ] 자동차들 중에서 가장 멀리 간 위치가 어디인지 알 수 있다
- [ ] 특정 위치에 해당하는 자동차들을 알 수 있다.
- [ ] 자동차가 한대만 우승한 경우 -
- [ ] 자동차가 여러대가 우승한 경우 -
------

### 콘솔뷰어
- [ ] 경기장 자동자 이름 리스트 받기
- [ ] 경기장 라운드 받기
- [ ] 현재 자동차 진행상태 출력
- [ ] 우승자 출력

2023-03-06 추가 요구사항
1. TDD을 통해 리팩토링
2. 규칙 2개 추가(모든 원시값과 문자열을 포장, 일급 컬렉션을 사용)
3. 비즈니스는 domain 패키지로, UI 관련 객체를 view에 위치
4. MVC 패턴 기반으로 리팩터링하여 view가 직접 domain을 사용하지 않도록

## 규칙
1. 자바 코드 컨벤션을 지키면서 프로그래밍한다. 기본적으로 Google Java Style Guide을 원칙으로 한다.
2. 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다. (이건 자체적으로 안함 2spaces로)
3. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. (예 :while문 안에 if문이 있으면 들여쓰기는 2이다.) 
   힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
4. 3항 연산자를 쓰지 않는다.
5. 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외
6. indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
7. else 예약어를 쓰지 않는다. (switch case 포함)
8. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.


## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)