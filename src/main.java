import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws ScannerExeption {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Input:");
            String str = scanner.nextLine().toUpperCase();
            System.out.println("Output:");
            System.out.println(calc(str));
            System.out.println();
        }

    }


    public static String calc(String input) throws ScannerExeption {
        String[] parts;
        String out = null;
        int a;
        int b;
        int c;
        try {
            parts = input.split(" ");
            String operand1 = parts[0];
            String operand2 = parts[2];
            String operation = parts[1];
            if (isNum(operand1) && isNum(operand2)) {
                out = intCalc(operand1, operand2, operation);
            } else if (isRim(operand1) && isRim(operand2)) {
                a = rimToNums(operand1);
                b = rimToNums(operand2);
                c = rimCalc(a, b, operation);
                out = convertNumToRim(c);

            } else {
                throw new ScannerExeption("Введите арабские числа  от 1 до 10 или римские числа от I до X в формате: A + B | A * B | A - B | A / B");
            }
        }

         catch (ArrayIndexOutOfBoundsException e){
            throw new ScannerExeption("Введите арабские числа  от 1 до 10 или римские числа от I до X в формате: A + B | A * B | A - B | A / B");

        }
        return out;
    }

    public static boolean isRim (String str) {
        try {
            int i = rimToNums(str);
            return i > 0 && i <= 10;
        } catch (NumberFormatException | ScannerExeption e) {
            return false;
        }
    }

    public static boolean isNum(String str) {
        try {
            int i = Integer.parseInt(str);
            return i > 0 && i <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isChar(String str) {
        if (str.contains("+") | str.contains("-") | str.contains("*") | str.contains("/")) {
            try {
                char c = str.charAt(0);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String intCalc(String operand1, String operand2, String operation) throws ScannerExeption {
        String out = null;
        if (isChar(operation)) {
            int a = Integer.parseInt(operand1);
            int b = Integer.parseInt(operand2);
            char c = operation.charAt(0);
            switch (c) {
                case '+' -> out = Integer.toString(a + b);
                case '-' -> out = Integer.toString(a - b);
                case '*' -> out = Integer.toString(a * b);
                case '/' -> out = Integer.toString(a / b);
            }
        } else {
            throw new ScannerExeption("Между двумя числами нужно поставить знак: (+), (-), (*), или (/)");
        }
        return out;
    }

    public static int rimToNums(String rim) throws ScannerExeption {
        try {
            if (rim.equals("I")) {
                return 1;
            } else if (rim.equals("II")) {
                return 2;
            } else if (rim.equals("III")) {
                return 3;
            } else if (rim.equals("IV")) {
                return 4;
            } else if (rim.equals("V")) {
                return 5;
            } else if (rim.equals("VI")) {
                return 6;
            } else if (rim.equals("VII")) {
                return 7;
            } else if (rim.equals("VIII")) {
                return 8;
            } else if (rim.equals("IX")) {
                return 9;
            } else if (rim.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new ScannerExeption("Введите арабские или римские числа от 1 до 10/ от I до X в формате: A + B или A * B");
        }
        return -1;
    }

    public static int rimCalc(int operand1, int operand2, String operation) throws ScannerExeption {
        int out = 0;
        if (isChar(operation)) {
            int a = operand1;
            int b = operand2;
            char c = operation.charAt(0);
            switch (c) {
                case '+' -> out = (a + b);
                case '-' -> out = (a - b);
                case '*' -> out = (a * b);
                case '/' -> out = (a / b);
            }
        } else {
            throw new ScannerExeption("Между двумя числами нужно поставить знак: (+), (-), (*), или (/)");
        }
        return out;


    }

    public static String convertNumToRim (int num) throws ScannerExeption {

        if (num >= 0){
            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            final String out = roman[num];
            return out;
        } else {
            throw new ScannerExeption("Результат с Римскими числами не может быть отрицательным!");
        }


        }


















































}



