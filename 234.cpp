#include <bits/stdc++.h>
using namespace std;

void solve() {
    int pilas, cargamin, izq, der, contador;
    cin >> pilas;
    cin >> cargamin;
    vector<int> cargas(pilas);

    for (int i = 0; i < pilas; i++) {
        cin >> cargas[i];
    }

    sort(cargas.begin(), cargas.end());

    izq = 0;
    der = cargas.size() - 1;
    contador = 0;

    while (izq < der) {
        if (cargas[izq] + cargas[der] >= cargamin) {
            contador++;
            der--;
        }
        izq++;
    }
    cout << contador << endl;
}

int main() {
    ios_base::sync_with_stdio(0);
    int cases;
    cin >> cases;
    for (int t = 0; t < cases; t++) {
        solve();
    }
}