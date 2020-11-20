import sys
from collections import defaultdict, deque

input = sys.stdin.readline
pipe = defaultdict(lambda:defaultdict(int))

num = int(input())

#그래프 입력
for i in range(num):
    one, two, flow = map(str, input().split())
    pipe[one][two] += int(flow)
    pipe[two][one] += int(flow)

def bfs(start, sink, parent):
    visited = defaultdict(lambda:0)
    queue = deque()
    queue.append(start)
    visited[start] = 1
    while queue:
        u = queue.popleft()
        for i in pipe[u]:
            val = pipe[u][i]
            if visited[i]:
                continue
            if val <= 0:
                continue
            queue.append(i)
            visited[i] = 1
            parent[i] = u
    return 1 if visited[sink] else 0

def ford_fulkerson(start, sink):
    parent = defaultdict(lambda : -1)
    max_flow = 0
    while bfs(start, sink, parent):
        path_flow = float('inf')
        s = sink
        while s!= start:
            path_flow = min(path_flow, pipe[parent[s]][s])
            s = parent[s]
        max_flow += path_flow
        v = sink
        while v != start:
            u = parent[v]
            pipe[u][v] -= path_flow
            pipe[v][u] += path_flow
            v = parent[v]
    return max_flow

print(ford_fulkerson('A','Z'))