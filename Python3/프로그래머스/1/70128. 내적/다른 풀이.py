# zip 사용
def solution(a, b):
    return sum([x*y for x, y in zip(a,b)])

# zip & lambda 사용
solution = lambda x, y: sum(a*b for a, b in zip(x, y))

# zip
# 여러 개의 iterable(리스트, 튜플, 문자열 등)을 병렬로 묶어주는 기능
# 각 iterable의 동일한 인덱스에 있는 요소들을 하나의 튜플로 묶어 iterable 객체로 반환
