#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

int main() {
  string str, mString, pNum;
  vector<string> mTokens;
  vector<int> pTokens;

  cin >> str;

  stringstream ss(str);
  while (getline(ss, mString, '-')) {
    mTokens.push_back(mString);
  }
  
  for (int i=0; i < mTokens.size(); i++) {
    if (mTokens[i].find('+') != string::npos) {
      int tmp = 0;
      stringstream ss2(mTokens[i]);
      while (getline(ss2, pNum, '+')) {
        tmp += stoi(pNum);
      }
      mTokens[i] = to_string(tmp);
    }
  }

  int result = stoi(mTokens[0]);
  for (int i=1; i < mTokens.size(); i++) {
    result -= stoi(mTokens[i]); 
  }

  cout << result;
  
  return 0;
}