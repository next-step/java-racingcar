# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

## calculator.CalculatorTest
### 요구사항 분석
### To do
* [x] 빈 문자열 혹은 null 값을 입력할 경우 0을 반환한다. ("" => 0, null => 0)
* [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. ("1" => 1)
* [x] 쉼표 혹은 콜론을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 값의 합을 반환한다. ( "1,2:3" => 6)
* [x] 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우, RuntimeException 예외 throw한다. ("-1:2:3" => RuntimeException)
* [x] 커스텀 구분자를 지정할 수 있다. ("//;\n1;2;3" => 6)

### Feedback
* [x] junit4 의존성 삭제
* [x] 유닛 테스트 네이밍 코드 컨벤션 적용
* [x] 한 번만 수행해도 되는 코드 분리 (Patter.compile / split)
* [X] 양수임을 보장하는 값 객체를 활용한 숫자 이외의 값 혹은 음수 검증
* [x] Array => List 변경
* [x] ParameterizedTest를 활용한 여러 개의 테스트 수행
