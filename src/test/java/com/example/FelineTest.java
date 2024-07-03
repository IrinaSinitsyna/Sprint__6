package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void shouldReturnExpectedFamilyWhenGetFamilyIsCalled() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void shouldReturnExpectedResultWhenEatMeatIsCalled() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        List<String> actualResult = feline.eatMeat();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturnExpectedKittensAmountWhenGetKittensIsCalled() {
        Feline feline = new Feline();
        int expectedKittens = 1;

        int actualKittens = feline.getKittens();

        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void shouldReturnExpectedKittensAmountWhenGetKittensIsCalledWithParameter() {
        Feline feline = new Feline();

        for (int expectedKittens = 0; expectedKittens < 5; expectedKittens++) {
            int actualKittens = feline.getKittens(expectedKittens);
            assertEquals(expectedKittens, actualKittens);
        }
    }
}