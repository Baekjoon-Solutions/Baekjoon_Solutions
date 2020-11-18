import sys
sys.setrecursionlimit(10 ** 7)
input = sys.stdin.readline


def dfs(s, count):
    global result
    if visited[s]:
        return
    visited[s] = True

    if len(graph[s]) == 1 and visited[graph[s][0]]:
        result += count
        return

    for p in graph[s]:
        if not visited[p]:
            dfs(p, count + 1)


node_num = int(input())
graph = [[] for _ in range(node_num + 1)]
visited = [False] * (node_num + 1)
result = 0

for i in range(node_num - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


if __name__ == "__main__":
    dfs(1, 0)
    print('Yes' if result % 2 != 0 else 'No')