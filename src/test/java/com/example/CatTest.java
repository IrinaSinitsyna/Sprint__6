package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List ;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline predator;

    @Test
    public void shouldReturnExpectedSoundWhenGetSoundIsCalled() {
        Cat cat = new Cat(predator);
        String expectedSound = "Мяу";

        String actualSound = cat.getSound();

        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void shouldReturnExpectedFoodWhenGetFoodIsCalled() throws Exception {
        Cat cat = new Cat(predator);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedResult);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedResult, actualFood);
    }
}