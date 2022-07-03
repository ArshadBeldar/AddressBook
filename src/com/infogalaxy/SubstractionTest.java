package com.infogalaxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstractionTest {

    @Test
    void sub() {
        Substraction substraction = new Substraction();

        Assertions.assertEquals(10,substraction.sub(50,40));


    }
}