#include <iostream>
#include <vector>
using namespace std;

int main() {
  int N, K; // 동전 종류, 만들어야 하는 돈
  cin >> N >> K;

  vector<int> arr(N);
  int count = 0;

  for (int i=0; i<N; i++) {
    cin >> arr[i];
  }

  while (K > 0) {
    for (int i=N-1; i>=0; i--) {
      if (arr[i] <= K) {
        count += K / arr[i];
        K %= arr[i];
      }
    }
  }

  cout << count;
  
  return 0;
}