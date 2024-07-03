package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class LionManeTest {

    private String sex;
    private boolean expectedMane;

    public LionManeTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Collection provider() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false }
        });
    }

    @Before
    public void init() {
        initMocks(this);
    }

    @Test
    public void shouldReturnManeAccordingToSexWhenHasManeIsCalled() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(sex, feline);

        boolean actualHasMane = lion.doesHaveMane();

        assertEquals(expectedMane, actualHasMane);
    }
}