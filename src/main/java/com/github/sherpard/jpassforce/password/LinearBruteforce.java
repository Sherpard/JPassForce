package com.github.sherpard.jpassforce.password;

public class LinearBruteforce extends PasswordGuesserAbstract {

  private char[] charDictionary;
  private int[] currentPassword;
  private int passwordLength;

  LinearBruteforce() {

  }

  @Override
  public String solvePasswordImpl(String dictionary, int length) {

    this.charDictionary = dictionary.toCharArray();
    this.currentPassword = new int[length];
    this.passwordLength = length;

    for (int i = 0; i < length; i++) {
      currentPassword[i] = 0;
    }

    while (!isPasswordFound()) {
      if (!setNextPassword()) {
        break;
      }
    }

    if (isPasswordFound()) {
      return getCurrentPassword();
    } else {
      return "Password not found";
    }

  }

  private String getCurrentPassword() {
    StringBuilder currPass = new StringBuilder();
    for (int i : currentPassword) {
      currPass.append(charDictionary[i]);
    }
    System.out.println("Trying " + currPass.toString());
    return currPass.toString();

  }

  private boolean isPasswordFound() {
    return super.checkPassword(getCurrentPassword());
  }

  private boolean recursivelySetNextPassword(int currIdx) {
    if (currentPassword[currIdx] < this.charDictionary.length - 1) {
      currentPassword[currIdx] += 1;
      return true;
    } else {
      if (currIdx < this.passwordLength - 1) {
        return recursivelySetNextPassword(currIdx + 1);
      }
    }
    return false;
  }

  private boolean setNextPassword() {

    return recursivelySetNextPassword(0);
  }

}
