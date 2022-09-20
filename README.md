# 기능 구현 목록

## 입력
- [x] 자동차 대수를 입력받는다.
- [x] 이동 시도 횟수를 입력받는다.

## 출력
- [ ] 각 이동 시도마다 자동차들의 이동 현황을 출력한다.

## 도메인
- [x] 주어진 횟수동안 n대의 자동차는 랜덤 값에 따라 전진 또는 멈춘다.
  - [x] move : 랜덤 값이 4이상 9이하인 경우
  - [x] stop : 랜덤 값이 0이상 3이하인 경우
- [ ] 예외 처리
  - [x] 숫자가 아닌 것을 입력 시, 입력 제한 안내 메시지 던지기.
  - [ ] 음수 입력 시, 입력 숫자 범위 안내 메시지 던지기.