package com.example.steps;
import org.example.Circle;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.ru.Когда;
import static org.junit.jupiter.api.Assertions.*;

public class CircleStepDefinitions {
    private double radius;
    private double result;
    private Exception exception;

    @Дано("радиус {double}")
    public void setRadius(double radius) {
        this.radius = radius;
        System.out.println("Радиус: " + radius);  // Логирование, чтобы понять, передается ли значение
    }

    @Когда("Вычисление площади круга")
    public void вычисляется_площадь_круга() {
        try {
            result = Circle.calculateArea(radius);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Тогда("результат должен быть {double}")
    public void результат_должен_быть(double expected) {
        assertEquals(expected, result, 1e-9);
    }

    @Тогда("должна возникнуть ошибка")
    public void должна_возникнуть_ошибка() {
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }
}