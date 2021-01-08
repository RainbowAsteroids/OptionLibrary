package xyz.portal2d.OptionLibrary;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class IntegerPrompt {
    static private final String defaultMessage = "Please input a number: ";

    static BigInteger integerPrompt() {
        return integerPrompt(defaultMessage);
    }

    static BigInteger integerPrompt(InputStream inputStream) {
        return integerPrompt(defaultMessage, inputStream);
    }

    static BigInteger integerPrompt(String message) {
        return integerPrompt(message, System.in);
    }

    static BigInteger integerPrompt(String message, InputStream inputStream) {
        BigInteger returnValue;
        Scanner scanner = new Scanner(inputStream);

        System.out.print(message);
        returnValue = scanner.nextBigInteger();

        return returnValue;
    }
}