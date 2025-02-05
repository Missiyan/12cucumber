import io.qameta.allure.*;
import org.example.Circle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Калькулятор круга")
@Feature("Расчёт площади круга")
public class CircleTest {

    @ParameterizedTest
    @CsvSource({
            "1.0, 3.14159",
            "2.0, 12.56636",
            "3.0, 28.27433"
    })
    @Story("Проверка расчёта площади для валидных радиусов")
    @Description("Тестирует правильность метода calculateArea для различных радиусов.")
    void testCalculateArea(double radius, double expectedArea) {
        assertEquals(expectedArea, Circle.calculateArea(radius), 0.0001, "Area calculation is incorrect");
    }

    @Test
    @Story("Обработка некорректного радиуса")
    @Description("Проверяет, что метод calculateArea выбрасывает исключение для отрицательного радиуса.")
    void testInvalidRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Circle.calculateArea(-1));
        assertEquals("Radius must be positive", exception.getMessage());
    }
}