# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---

# 문자열 계산기
## 기능 요구 사항
- [x] 입력받은 문자열에 따라 사칙 연산(-, +, /, *)을 수행할 수 있다. - `Calculator`
  - [x] 입력값을 숫자와 부호로 나누는 함수 - `Calculator`.splitInput
- [x] 사용자의 입력을 받는다.
  - [x] 오류 검증
    - [x] 입력값이 `null`, 공백일 경우 `IllegalArgumentException`
    - [x] 사칙 연산 기호가 아닌 경우 `IllegalArgumentException`
- [x] 계산된 결과값을 최종적으로 출력한다.
- [x] 계산기를 계속 실행할지 종료할지를 사용자 입력값에 따라 결정