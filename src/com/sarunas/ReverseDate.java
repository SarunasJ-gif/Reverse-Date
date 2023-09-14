package com.sarunas;

public class ReverseDate {

    public void printBonusDatesBetween(int fromYear, int toYear) {
        if (!isValidYear(fromYear) || !isValidYear(toYear) || fromYear > toYear) {
            System.out.println("Is not valid year...");
        }
        for (int year = fromYear; year < toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int days = getDays(year, month);
                for (int day = 1; day <= days; day++) {
                    if (isReverseDate(year, month, day)) {
                        System.out.printf("%04d-%02d-%02d%n", year, month, day);
                    }
                }
            }
        }
    }

    private int getDays(int year, int month) {
        if (month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private boolean isValidYear(int year) {
        if (year < 1) {
            return false;
        }
        return true;
    }

    private boolean isReverseDate(int year, int month, int day) {
        String date = String.format("%04d%02d%02d", year, month, day);
        String reverseDate = new StringBuilder(date).reverse().toString();
        return date.equals(reverseDate);
    }
}
