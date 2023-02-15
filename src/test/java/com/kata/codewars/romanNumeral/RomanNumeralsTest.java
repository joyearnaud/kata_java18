package com.kata.codewars.romanNumeral;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        assertEquals("I", RomanNumerals.toRoman(1), "1 converts to 'I'");
        assertEquals("II", RomanNumerals.toRoman(2), "2 converts to 'II'");
        assertEquals("MLXXX", RomanNumerals.toRoman(1080), "1080 converts to 'MLXXX'");
        assertEquals("DLXX", RomanNumerals.toRoman(570), "1080 converts to 'DLXX'");
        assertEquals("IV", RomanNumerals.toRoman(4), "4 converts to 'IV'");
        assertEquals("XL", RomanNumerals.toRoman(40), "40 converts to 'XL'");
        assertEquals("XLVIII", RomanNumerals.toRoman(48), "48 converts to 'XLVIII'");
        assertEquals("MCMXC", RomanNumerals.toRoman(1990), "1990 converts to 'MCMXC'");
        assertEquals("MMVIII", RomanNumerals.toRoman(2008), "2008 converts to 'MMVIII'");
        assertEquals("MDCLXVI", RomanNumerals.toRoman(1666), "1666 converts to 'MDCLXVI'");
    }

    @Test
    public void testFromRoman() throws Exception {
        assertEquals(1, RomanNumerals.fromRoman("I"), "'I' converts to 1");
        assertEquals(2, RomanNumerals.fromRoman("II"), "'II' converts to 2");
        assertEquals(1666, RomanNumerals.fromRoman("MDCLXVI"), "'II' converts to 2");
        assertEquals(44, RomanNumerals.fromRoman("XLIV"), "'XLIV' converts to 44");
        assertEquals(3839, RomanNumerals.fromRoman("MMMDCCCXXXIX"), "'MMMDCCCXXXIX' converts to 3839");
    }

//    @Test
    public void runBenchmarks() throws Exception {
        Options options = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(0))
                .warmupIterations(0)
                .threads(2)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchToRoman1() throws Exception {
        RomanNumerals.toRoman(1);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchToRoman2() throws Exception {
        RomanNumerals.toRoman(2);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchToRoman4() throws Exception {
        RomanNumerals.toRoman(4);
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void benchToRoman1666() throws Exception {
        RomanNumerals.toRoman(1666);
    }

//    @Benchmark
//    @OutputTimeUnit(TimeUnit.MILLISECONDS)
//    public void benchToNumerals() throws Exception {
//        RomanNumerals.fromRoman("I");
//    }
}