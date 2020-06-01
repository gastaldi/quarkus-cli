package io.quarkus.cli;

public class Printer {
    private static final String OK = "\u2705";
    static final String NOK = "\u274c";
    private static final String NOOP = "\uD83D\uDC4D";

    public static void nok(String content) {
        print(NOK + content);
    }

    public static void ok(String content) {
        print(OK + content);
    }

    public static void noop(String content) {
        print(NOOP + content);
    }

    static void print(String message) {
        System.out.println(message);
    }

}
