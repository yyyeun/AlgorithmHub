# num/2의 수들만 검사하면 성능 약 2배 향상
def sumDivisor(num):
    return num + sum([i for i in range(1, (num // 2) + 1) if num % i == 0])

# list comprehension
def sumDivisor(num):
    return sum([i for i in range(1,num+1) if num%i==0])

# filter + lambda
def sumDivisor(num):
    return sum(filter(lambda x: num % x == 0, range(1, num + 1)))
