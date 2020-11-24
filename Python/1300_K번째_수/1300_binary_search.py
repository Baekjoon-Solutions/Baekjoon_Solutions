num, num2 = int(input()), int(input())

left, right = 1, num2

while left <= right:
    mid = (left + right) // 2

    tmp = 0
    for i in range(1, num + 1):
        tmp += min(mid // i, num)

    if tmp >= num2:
        result = mid
        right = mid - 1
    else:
        left = mid + 1
            
print(result)