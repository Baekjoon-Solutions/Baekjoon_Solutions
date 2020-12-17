#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int carry = 0;

int main() {
	ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

	string num01;
	string num02;
	string result = "";

	cin >> num01 >> num02;

	int x = num01.size() - 1;
	int y = num02.size() - 1;

	int sum = 0;
	while (x >= 0 && y >= 0)
	{
		sum = (num01[x] - '0') + (num02[y] - '0') + carry;

		if (sum > 9) {
			carry = 1;
			sum = sum - 10;
		}
		else {
			carry = 0;
		}
		result = to_string(sum) + result;

		x = x - 1;
		y = y - 1;
	}

	while (x >= 0)
	{
		sum = (num01[x] - '0') + carry;

		if (sum > 9) {
			carry = 1;
			sum = sum - 10;
		}
		else {
			carry = 0;
		}

		result = to_string(sum) + result;
		x = x - 1;
	}

	while (y >= 0)
	{
		sum = (num02[y] - '0') + carry;

		if (sum > 9) {
			carry = 1;
			sum = sum - 10;
		}
		else {
			carry = 0;
		}

		result = to_string(sum) + result;
		y = y - 1;
	}

	if (carry == 1) {
		result = to_string(1) + result;
	}

	cout << result;

	return 0;
}
