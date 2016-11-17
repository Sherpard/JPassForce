package com.github.sherpard.jpassforce.gui;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import com.github.sherpard.jpassforce.Alphabet;
import com.github.sherpard.jpassforce.Alphabet.ALPHABET_TYPE;
import com.github.sherpard.jpassforce.PasswordLenghtComputer;

public class Console {

  public static void main(String[] args) {

    System.out.println("JPassForce console GUI");
    System.out.println("");

    ALPHABET_TYPE selectedAlphabet;
    Integer passwordLenght;
    try (Scanner in = new Scanner(System.in)) {

      selectedAlphabet = requestAlphabet(in);
      System.out.println("Selected Alphabet: " + selectedAlphabet.toString());
      passwordLenght = requestPasswordLength(in);
    }

    BigInteger totalPasswords = PasswordLenghtComputer.getPasswordCount(selectedAlphabet,
        passwordLenght);

    System.out.println("A password with a lenght of " + passwordLenght);
    System.out.println(
        "using an alphabet with " + Alphabet.getAlphabet(selectedAlphabet).length() + " variants");
    System.out.println("Has " + String.format("%,d", totalPasswords) + " potential passwords");

  }

  private static Integer requestPasswordLength(Scanner in) {

    while (true) {
      System.out.println();
      System.out.print("Password Lenght: ");
      String result = in.nextLine();
      if (StringUtils.isNumeric(result)) {
        return Integer.parseInt(result);
      } else {
        System.err.println("String supplied is not a number");
      }
    }
  }

  private static ALPHABET_TYPE requestAlphabet(Scanner in) {
    while (true) {
      System.out.println("Chose an alphabet:");
      System.out.println(
          "\t1 - UPPERCASE (" + Alphabet.getAlphabet(ALPHABET_TYPE.ALPHABETIC_UPPERCASE) + ")");
      System.out.println(
          "\t2 - LOWERCASE (" + Alphabet.getAlphabet(ALPHABET_TYPE.ALPHABETIC_LOWERCASE) + ")");
      System.out.println("\t3 - NUMBERS (" + Alphabet.getAlphabet(ALPHABET_TYPE.NUMERIC) + ")");
      System.out.println(
          "\t4 - ALPHANUMERIC (" + Alphabet.getAlphabet(ALPHABET_TYPE.ALPHANUMERIC_FULL) + ")");
      String result = in.nextLine();

      switch (result.trim()) {
      case "1":
        return ALPHABET_TYPE.ALPHABETIC_UPPERCASE;
      case "2":
        return ALPHABET_TYPE.ALPHABETIC_LOWERCASE;
      case "3":
        return ALPHABET_TYPE.NUMERIC;
      case "4":
        return ALPHABET_TYPE.ALPHANUMERIC_FULL;
      default:
        System.err.println("Invalid Alphabet selected");
        break;
      }
    }
  }

}
