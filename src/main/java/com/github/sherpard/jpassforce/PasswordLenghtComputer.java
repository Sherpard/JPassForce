package com.github.sherpard.jpassforce;

import java.math.BigInteger;

import com.github.sherpard.jpassforce.Alphabet.ALPHABET_TYPE;

/**
 * 
 * @author Sherpard
 *
 *         Computes the length of a password given a dictionary and a password length.
 */
public class PasswordLenghtComputer {

  private PasswordLenghtComputer() {
    // Do nothing
  }

  /**
   * Returns a representation of how many passwords are available with given conditions.
   * 
   * @param alphabet
   *          The alphabet type
   * @param passwordLenght
   *          Password Length
   * @return Passwords available
   */
  public static BigInteger getPasswordCount(ALPHABET_TYPE alphabet, Integer passwordLenght) {
    BigInteger base = new BigInteger(Alphabet.getAlphabet(alphabet).length() + "");
    return base.pow(passwordLenght);
  }
}
