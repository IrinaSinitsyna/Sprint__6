package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void shouldReturnExpectedFoodWhenGetFoodIsCalled() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void shouldReturnExpectedKittensWhenGetKittensIsCalled() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittens = 2;
        when(feline.getKittens()).thenReturn(expectedKittens);

        int actualKittens = lion.getKittens();

        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void shouldThrowExpectedExceptionWhenLionCreatedWithNotExpectedSex() {
        String expectedMessage = "Используйте допустимые значения пола животного - самей или самка";
        Exception actualException = null;
        try {
            new Lion("Неожиданный пол", feline);
        } catch (Exception e) {
            actualException = e;
        }
        assertNotNull(actualException);
        assertEquals(expectedMessage, actualException.getMessage());
    }
}