import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorTest {

    @Test
    void validateName_validName() {
        assertEquals("Иван Иванов", DataValidator.validateName(" Иван   Иванов "));
    }

    @Test
    void validateName_invalidName() {
        assertEquals("", DataValidator.validateName("John Smith"));
        assertEquals("", DataValidator.validateName("Иван"));
    }

    @Test
    void validateAge_validAge() {
        assertEquals("25", DataValidator.validateAge("25"));
        assertEquals("30", DataValidator.validateAge("возраст: 30"));
    }

    @Test
    void validateAge_invalidAge() {
        assertEquals("", DataValidator.validateAge("-5"));
        assertEquals("", DataValidator.validateAge("abc"));
        assertEquals("", DataValidator.validateAge("150"));
    }

    @Test
    void validatePhone_russianPhone() {
        assertEquals("+7 (999) 123-45-67", DataValidator.validatePhone("+7 999 123 45 67"));
    }

    @Test
    void validatePhone_internationalPhone() {
        assertEquals("+441234567890", DataValidator.validatePhone("+44 123 456 7890"));
    }

    @Test
    void validatePhone_invalidPhone() {
        assertEquals("", DataValidator.validatePhone("12345"));
    }

    @Test
    void validateEmail_validEmail() {
        assertEquals("test@example.com", DataValidator.validateEmail("test@example.com"));
    }

    @Test
    void validateEmail_invalidEmail() {
        assertEquals("", DataValidator.validateEmail("invalid@@example..com"));
        assertEquals("", DataValidator.validateEmail("no-at-symbol.com"));
    }
}
