package org.example;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите радиус круга: ");
        double radius = scanner.nextDouble();

        if (radius <= 0) {
            System.out.println("Радиус должен быть положительным числом.");
        } else {
            double area = calculateArea(radius);
            System.out.printf("Площадь круга с радиусом %.2f равна %.2f%n", radius, area);
        }
    }

    public static double calculateArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        return Math.PI * radius * radius;
    }
}