package com.github.sherpard.jpassforce.password;

import org.apache.commons.lang3.NotImplementedException;

public abstract class PasswordGuesserAbstract {

  public enum StrategyType {
    LINEAR_BRUTEFORCE, MULTITHREADED, DISTRIBUTED
  }

  public static PasswordGuesserAbstract getPasswordSolver(StrategyType strategy) {
    switch (strategy) {
    case LINEAR_BRUTEFORCE:
      return new LinearBruteforce();
    default:
      throw new NotImplementedException("Strategy not implemented yet");
    }
  }

  private String password;

  protected PasswordGuesserAbstract() {
  }

  public final String solvePassword(String dictionary, int passwordLenght) {
    createRandomPassword(dictionary, passwordLenght);
    return this.solvePasswordImpl(dictionary, passwordLenght);
  }

  private void createRandomPassword(String dictionary, int lenght) {
    for (int i = 0; i < lenght; i++) {
      this.password += dictionary.charAt(dictionary.length() - 1);
    }

  }

  protected final boolean checkPassword(String guessedPassword) {
    return guessedPassword.equals(password);
  }

  protected abstract String solvePasswordImpl(String dictionary, int length);
}
