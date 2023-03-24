#include <bits/stdc++.h>
using namespace std;

void solve(int num) {
    int number;
    int sum = 0;
    int n = num;
    bool exit = true;

    cout << n << " -";
    if (n == 1) {
        cout << "> cubifinito." << endl;
        return;
    }
    while (exit) {
        number = n;
        while (n) {
            sum += pow(n%10, 3);
            n /= 10;
        }

        cout << " " << sum << " -";

        if (sum == number) {
            cout << "> no cubifinito." << endl;
            exit = false;
        } else if (sum == 1) {
            cout << "> cubifinito." << endl;
            exit = false;
        } else {
            n = sum;
            sum = 0;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    int number;
    
    while (true) {
        cin >> number; 
        if (number == 0) {
            break;
        }
        solve(number);
    }
    return 0;
}