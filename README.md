# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 계산기

## 기능 구현 사항

- [X] 입력
  - [X] 숫자하고 계산기 특수문자(`+ * / -`)를 제외하면 오류 처리한다.
  - [X] 각 문자사이 공백은 한칸이다. 한칸이 넘으면 에러 처리한다. 
  - [X] 입력인 `null`이거나 공백문자이면 `IllegalArgumentException throw`
  - [X] 사칙연산 기호가 아닌 경우 `IllegalArgumentException throw`
- [X] 파싱
- [ ] 계산
  - [ ] 문자열 계산기는 사칙 연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
  - [ ] 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다. 
  - [ ] 예를 들어 `2 + 3 * 4 / 2`와 같은 문자열을 입력할 경우 `2 + 3 * 4 / 2` 실행 결과인 10을 출력해야 한다.
- [ ] 결과 반환

## 마감 기한

목요일 18시

## multiple authors

```bash
git commit -m "commit message


Co-authored-by: hochan222 <hochan049@gmail.com>
Co-authored-by: kworkbee <g1.tommy.jeon@gmail.com>"
```