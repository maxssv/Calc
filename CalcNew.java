import java.io.IOException;
import java.util.Scanner;

public class CalcNew {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] primer = sc.nextLine().split(" ");

        if (primer.length == 1) {
            throw new IOException("Строка не является математической операцией");
        }

        var perem1 = primer[0];
        var arefm = primer[1];
        var perem2 = primer[2];
        var num1 = 0;
        var num2 = 0;
        var sum = 1;

        String[] rimskie = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIV", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIV", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI"};
        String[] arabskie = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


        for (String s : arabskie) {
            if (perem1.equals(s)) {
                for (String value : rimskie) {
                    if (perem2.equals(value)) {
                        throw new IOException("Используются одновременно разные системы счисления");
                    }
                }
            }
        }

        for (String s : rimskie) {
            if (perem1.equals(s)) {
                for (String value : arabskie) {
                    if (perem2.equals(value)) {
                        throw new IOException("Используются одновременно разные системы счисления");
                    }
                }
            }
        }

        if (primer.length != 3) {
            throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }


        for (int value = 0; value < rimskie.length; value++) {
            if (perem1.equals(rimskie[value])) {
                num1 = value + 1;
            }
        }
        for (int value = 0; value < rimskie.length; value++) {
            if (perem2.equals(rimskie[value])) {
                num2 = value + 1;
            }
        }

        if (num1 >= 10 || num2 >= 10) {
            throw new IOException("Переменные не могут быть больше 9");
        } else if (arefm.equals("+")) {
            sum = num1 + num2;
        } else if (arefm.equals("-")) {
            sum = num1 - num2;
        } else if (arefm.equals("*")) {
            sum = num1 * num2;
        } else if (arefm.equals("/")) {
            sum = num1 / num2;
        }
        for (int value1 = 0; value1 < rimskie.length; value1++) {
            if (sum == value1 + 1) {
                System.out.println(rimskie[value1]);
                return;
            }
        }

        for (String s : rimskie) {
            if (perem1.equals(s)) {
                for (String value : rimskie) {
                    if (perem2.equals(value)) {
                    } else if (sum <= 0) {
                        throw new IOException("В римской системе нет отрицательных чисел");
                    }
                }
            }
        }

        num1 = Integer.parseInt(perem1);
        num2 = Integer.parseInt(perem2);

        if (num1 >= 10 || num2 >= 10) {
            throw new IOException("Числа на ввод не могут быть больше 9");
        } else if (num2 <= 10 && num2 >= 1 && num1 <= 10 && num1 >= 1 && arefm.equals("+")) {
            System.out.println(num1 + num2);
        } else if (num2 <= 10 && num2 >= 1 && num1 <= 10 && num1 >= 1 && arefm.equals("-")) {
            System.out.println(num1 - num2);
        } else if (num2 <= 10 && num2 >= 1 && num1 <= 10 && num1 >= 1 && arefm.equals("/")) {
            System.out.println(num1 / num2);
        } else if (num2 <= 10 && num2 >= 1 && num1 <= 10 && num1 >= 1 && arefm.equals("*")) {
            System.out.println(num1 * num2);
        }
    }
}
