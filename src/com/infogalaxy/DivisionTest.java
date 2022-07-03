package com.infogalaxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    @Test
    void div() {
        Division division = new Division();

        Assertions.assertEquals(1,division.div(10,10));
    }
}