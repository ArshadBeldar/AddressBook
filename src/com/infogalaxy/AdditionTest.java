package com.infogalaxy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
    @Test
    void Add(){
        Addition addition = new Addition();

        Assertions.assertEquals(10,addition.Add(5,5));

    }

}