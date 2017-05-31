package com.mono.testing.m6;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;


public class SalesAnaliserTest {
    // provided
    private static final List<Sale> exampleSales = Arrays.asList(
            new Sale("Cardiff", 10,2),
            new Sale("Cardiff", 3,5),
            new Sale("Cardiff", 6,20),
            new Sale("London", 5,7)
    );

    // expected
    private static Map<String, Integer> expectedSales = new HashMap<String, Integer>();
    static {
        expectedSales.put("London", 35);
        expectedSales.put("Cardiff", 155);
    }

    @Test
    public void shoudlAggreagateStoreSales(){

        // arrange
        SalesRepository mockRepository = mock(SalesRepository.class);
        when(mockRepository.loadSales()).thenReturn(exampleSales);
            // system under test with injection
        SalesAnalyser _sut = new SalesAnalyser(mockRepository);
        // act
        Map<String, Integer> storeSales = _sut.TallyCitySales();
        // assert
        Assert.assertEquals("Calculated wrong store sales", expectedSales, storeSales);
        verify(mockRepository, times(1)).loadSales();
    }
}
