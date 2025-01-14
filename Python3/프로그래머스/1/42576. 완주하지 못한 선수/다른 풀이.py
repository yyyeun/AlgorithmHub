# 1-1. Counter 객체 사용 (긴 버전)
from collections import Counter

def solution(participant, completion):
    count = Counter(participant)
    for person in completion:
        count[person] -= 1
        if count[person] == 0:
            del count[person]
    return list(count.keys())[0]


# 1-2. Counter 객체 사용 (짧은 버전)
from collections import Counter

def solution(participant, completion):
    return list((Counter(participant) - Counter(completion)).keys())[0]


# 2. hash 함수 사용
def solution(participant, completion):
    hash_dict = {}
    hash_sum = 0

    for p in participant:
        hash_dict[hash(p)] = p
        hash_sum += hash_value

    for c in completion:
        hash_sum -= hash(c)

    return hash_dict[hash_sum]

# 시간 복잡도
# 기존 풀이 (정렬) -> O(NlogN)
# 해시맵 사용 -> O(N+M)
