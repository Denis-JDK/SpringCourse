package ru.example.springcourse.controllers.house;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static int result;
    public static List<Integer> oldResult = new ArrayList<>();
    public static void main(String[] args) {


            System.out.println("1. Ввести пример");
            System.out.println("2. Продолжить работу с предыдущим ответом");
            System.out.println("3. Выход");

            Scanner scanner = new Scanner(System.in);
            int operation = Integer.parseInt(scanner.nextLine());

            if (operation == 1) {
                String expr = scanner.nextLine();
                String[] arr = expr.split(" ");
                int a = Integer.parseInt(arr[0]);
                String operator = arr[1];
                int b = Integer.parseInt(arr[2]);
                result = operation(a, b, operator);
                oldResult.add(result);
                System.out.println("Результат: "+ a + operator + b + "="+ result);
            } else if (operation == 2 && oldResult.size() != 0) {
                int a = oldResult.get(oldResult.size());
                System.out.println(result);
                String expr = scanner.nextLine();
                String[] arr = expr.split(" ");
                String operator = arr[0];
                int b = Integer.parseInt(arr[1]);
                result = operation(a, b, operator);
                System.out.println("Результат: "+ a + operator + b + "="+ result);
            } else if (operation == 3) {
                System.exit(0);
            } else {
                System.out.println("Предыдущий результат отсутствует");
            }
            }



        public static int operation(int a, int b, String operator){
            switch (operator) {
                case "+":
                   return result = a + b;
                case "-":
                  return   result = a - b;
                case "*":
                  return   result = a * b;
                case "/":
                return     result = (a == 0 || b == 0) ? 0 : a / b;
                case "!":
                    long c = calc(a);
                    return (int) c;
                case "^":
                    while (b!=0){
                        result = a*a;
                        b--;
                    }
                 return result;

                case "?":
                    if (a>b) return result = a;
                    else return result = b;

                default:
                   System.out.println("Введите + - / ! ^ ?");
            }
            return result;
        }

    public static long calc(long n) {
        if (n <= 1)
            return 1;
        else
            return n * calc(n - 1);
    }
    }
