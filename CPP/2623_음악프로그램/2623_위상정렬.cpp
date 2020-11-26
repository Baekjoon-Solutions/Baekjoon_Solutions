#include<iostream>
#include<vector>
#include<queue>

using namespace std;
vector<int> v[1001];
int N, M;
int cost[1001];
bool used[1001][1001];
queue<int> ans;

int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		int a; cin >> a;
		if (a == 0) continue;
		int b; cin >> b;
		for (int j = 0; j < a - 1; j++) {
			int c; cin >> c;
			if (!used[b][c]) {
				v[b].push_back(c);
				cost[c]++;
			}
			b = c;
			used[b][c] = true; used[b][c] = true;
		}
	}
	queue<int> q;
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}

	while (!q.empty()) {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int cur = q.front(); q.pop();
			if (cost[cur] == 0) {
				ans.push(cur);
				for (auto j : v[cur]) {
					cost[j]--;
				}
			}
			else {
				q.push(cur);
			}
		}
		if (size == q.size()) {
			cout << "0";
			exit(0);
		}
	}
	while (!ans.empty()) {
		cout << ans.front() << "\n"; ans.pop();
	}
}
