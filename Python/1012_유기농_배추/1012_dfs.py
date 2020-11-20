import sys
sys.setrecursionlimit(10 ** 8)


def dfs(cabbage, i, j):
    cabbage[i][j] = 0

    dy = [1, -1, 0, 0]
    dx = [0, 0, 1, -1]
    for a in range(4):
        y = i + dy[a]
        x = j + dx[a]

        if 0 <= x < width and 0 <= y < height:
            if cabbage[y][x] == 1:
                dfs(cabbage, y, x)

    return 1


for _ in range(int(input())):
    width, height, k = map(int, input().split())
    cabbage = [[0 for i in range(width)] for j in range(height)]
    for i in range(k):
        x, y = map(int, input().split())
        cabbage[y][x] = 1

    result = []
    for i in range(height):
        for j in range(width):
            if cabbage[i][j] == 1:
                result.append(dfs(cabbage, i, j))

    print(len(result))
