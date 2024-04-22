package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class JSONValidatorTest {
    @Test
    public void testValidJSON() {
        JSONValidator validator = new JSONValidator();
        String filePath =
                Paths.get("src", "test", "resources", "with_asterisk.json").toString();
        assertFalse(validator.validate(filePath));
    }

    @Test
    public void testInvalidJSON() {
        JSONValidator validator = new JSONValidator();
        String filePath =
                Paths.get("src", "test", "resources", "without_asterisk.json").toString();
        assertTrue(validator.validate(filePath));
    }

    @Test
    public void testInvalidFile() {
        JSONValidator validator = new JSONValidator();
        String filePath =
                Paths.get("src", "test", "resources", "invalid.json").toString();
        assertThrows(JSONValidationException.class, () -> validator.validate(filePath));
    }

    @Test
    public void testInvalidStructure() {
        JSONValidator validator = new JSONValidator();
        String filePath =
                Paths.get("src", "test", "resources", "invalid_structure.json").toString();
        assertThrows(JSONValidationException.class, () -> validator.validate(filePath));
    }


}
