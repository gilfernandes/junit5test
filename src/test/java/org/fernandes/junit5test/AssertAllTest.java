package org.fernandes.junit5test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertAllTest {

    @Test
    void assertAllTest() {
        assertAll("Check conditions",
                () -> assertThat(checkCondition(9)).isTrue(),
                () -> assertThat(checkCondition(10)).isTrue(),
                () -> assertThat(checkCondition(11)).isTrue(),
                () -> assertThat(checkCondition(2)).isTrue(), // Throws exception
                () -> assertThat(checkCondition(3)).isFalse(), // fails
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    checkCondition(1);
                })
        );
    }

    private boolean checkCondition(int stuff) {
        if (stuff == 1 || stuff == 2) {
            throw new IllegalArgumentException(String.format("Stuff value was: %d", stuff));
        }
        return true;
    }
}
