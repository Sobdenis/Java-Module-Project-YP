import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    AccountCalculator сalculator = new AccountCalculator();

        сalculator.start();
}
}
    class AccountCalculator {
    ArrayList<String> сalculatorList = new ArrayList<>();
    ArrayList<Double> сalculatorDouble = new ArrayList<>();

    int userInput;
    String productName;
    Double productPrice;
    String productPriceString;
    String finish;
    Double totalСost = 00.00;

           private void сalculator() {
               Scanner scanner = new Scanner(System.in);


                  System.out.println("Введите название товара:");
                  productName = scanner.next();

                  сalculatorList.add(productName);
                  System.out.println("Введите стоимость в формате 00,00 руб.коп.:");
                  productPriceString = scanner.next();
                  productPriceString = productPriceString.replaceAll(",", ".");
                  while (!isNumeric(productPriceString)) {
                      System.out.print("Вы ввели некорректное значение\n");
                      productPriceString = scanner.next();
                  }

                  productPrice = Double.parseDouble(productPriceString);
                  сalculatorDouble.add(productPrice);
                  totalСost = totalСost + productPrice;
                  String result = String.format("%.2f", totalСost);
               System.out.print("\nСписок добавленного товара:\n");
               for (int i = 0; i < сalculatorList.size(); i++) {
                   String name = сalculatorList.get(i);
                   double price = сalculatorDouble.get(i);
                   String rubName = " рубль";
                   int rub1 = (int) price;
                   switch (rub1 % 10){ case 1:
                       rubName = " рубль"; break;
                       case 2: case 3: case 4:
                           rubName = " рубля"; break;
                       case 5: case 6: case 7: case 8: case 9: case 0:
                           rubName = " рублей";
                   }
                   System.out.print(i+1 + " " + name + " " + price + " " + rubName + "\n");
                    }

                  System.out.print("Общая стоимость: " + result + "\n \n");
                  System.out.print("Товар добавлен успешно! \nЧтобы продолжить добавление товара введите любой символ \nЧтобы завершить добавления товара введите команду 'Завершить'\n");
                  finish = scanner.next();
                  finish (finish, userInput, totalСost);
           }
        private void finish (String finish, int userInput, double totalСost) {
            String fin = "Завершить";
            String finСost = String.format("%.2f", (totalСost/userInput));
            System.out.print("\nСписок добавленного товара:\n");
            for (int i = 0; i < сalculatorList.size(); i++) {
                String name = сalculatorList.get(i);
                double price = сalculatorDouble.get(i);
                int namb = i;
                String rubName = " рубль";
                int rub1 = (int) price;
                switch (rub1 % 10){ case 1:
                    rubName = " рубль"; break;
                    case 2: case 3: case 4:
                        rubName = " рубля"; break;
                    case 5: case 6: case 7: case 8: case 9: case 0:
                        rubName = " рублей";
                }
                System.out.print(++namb + " " + name + " " + price + " " + rubName + "\n");
            }
            if (finish.equalsIgnoreCase(fin)) {
                System.out.print("Делим счет\n");
                System.out.print("Каждый должен заплатить " + finСost);
                int rub = (int) totalСost/userInput;
                    switch (rub % 10){ case 1:
                    System.out.println(" рубль"); break;
                    case 2: case 3: case 4:
                        System.out.println(" рубля"); break;
                    case 5: case 6: case 7: case 8: case 9: case 0:
                        System.out.println(" рублей"); break;
                }
            } else {
               сalculator();
            }
        }
           public static boolean isNumeric(String productPriceString) {
               try {
                   Double.parseDouble(productPriceString);
                   return true;
               } catch (NumberFormatException e) {
                   return false;
               }
           }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("На скольких человек необходимо разделить счёт \n(Введите количество человек более 1):");
            while (!scanner.hasNextInt()) {
                System.out.println("Это некорректное значение для подсчёта \n\n На скольких человек необходимо разделить счёт \n(Введите количество человек более 1):");
                scanner.next();
            }
            userInput = scanner.nextInt();
            if (userInput <=1) {
                System.out.println("Ошибка");
                start();
            }
        } while (userInput <= 1);
        System.out.println("Будем делить счёт на " + userInput + " чел.");
        сalculator();
    }
    }





