package com.github.sherpard.jpassforce;

public class Alphabet {

	private static final String NUMERIC_ALPHABET = "0123456789";
	private static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String FULL_ALPHABET = NUMERIC_ALPHABET + LOWERCASE_ALPHABET + UPPERCASE_ALPHABET;

	public enum ALPHABET_TYPE {
		NOT_SET, NUMERIC, ALPHABETIC_LOWERCASE, ALPHABETIC_UPPERCASE, ALPHANUMERIC_FULL
	}

	public static String getAlphabet(ALPHABET_TYPE alphabetType) {
		if (alphabetType == ALPHABET_TYPE.ALPHABETIC_LOWERCASE) {
			return LOWERCASE_ALPHABET;
		} else if (alphabetType == ALPHABET_TYPE.ALPHABETIC_UPPERCASE) {
			return UPPERCASE_ALPHABET;
		} else if (alphabetType == ALPHABET_TYPE.NUMERIC) {
			return NUMERIC_ALPHABET;
		} else {
			return FULL_ALPHABET;
		}
	}
}
