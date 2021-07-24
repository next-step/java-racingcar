# 2단계 - 문자열 계산기

## 기능 요구사항
- [x] 사용자가 입력한 문자열을 받는다
- [x] 사칙 연산 사이의 빈 공백 문자열 기반 split 한다
- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 사칙 연산을 모두 포함하는 기능 구현

```bash
2 + 3 * 4 / 2
```
실행 결과는 10이다.