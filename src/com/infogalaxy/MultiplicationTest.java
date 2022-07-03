package com.infogalaxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    @Test
    void mul() {
        Multiplication multiplication = new Multiplication();

        Assertions.assertEquals(25,multiplication.mul(5,5));
    }
}