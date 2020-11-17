#include<iostream>
#include<algorithm>
using namespace std;

// 최대공약수를 구하는 공식
int gcd(int x, int y) {
	while (y > 0)
	{
		int mod_value = x % y;
		x = y, y = mod_value;
	}
	return x;
}

// 최소공배수를 구하는 공식
int lcm(int x, int y, int gcd_value) {
	return x * y / gcd_value;
}

int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	int x, y;
	cin >> x >> y;

	int gcd_value = gcd(x, y);
	cout << gcd_value << "\n";
	cout << lcm(x, y, gcd_value);
}