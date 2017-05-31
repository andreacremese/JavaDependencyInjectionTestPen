package com.mono.testing.m6;


import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

// test for the sales report test
// it is the aggregation
public class SalesReportTest {

    private static final int TALLY = 235;
    private static final String CITY = "London";

    // these are the mock dependencies for the system under test
    PrintStream mockOut = mock(PrintStream.class);
    SalesAnalyser mockAnalyser = mock(SalesAnalyser.class);
    // this is the system under testing, its dependencies are specified above
    SalesReport _sut = new SalesReport(mockAnalyser,mockOut);

    @Test
    public void shouldPrintCityTally(){
        // arrange
        Map<String,Integer> cityMockTallies = new HashMap<String, Integer>();
        cityMockTallies.put(CITY,TALLY);

        when(mockAnalyser.TallyCitySales()).thenReturn(cityMockTallies);
        // act
        _sut.run();
        // assert

        // this asserts that a call to printf is made once and contained city and tally
        verify(mockOut).printf(anyString(), eq(CITY), eq(TALLY));
    }
}
