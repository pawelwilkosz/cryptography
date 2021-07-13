package com.github.pawelwilkosz.cryptography.test;

import com.github.pawelwilkosz.cryptography.basic.CaesarCode;
import org.junit.Assert;
import org.junit.Test;

public class CaesarCodeTests {
    @Test
    public void sanityTestDecoding(){
        //Given
        final String original = "abc";
        final String destination = "def";
        CaesarCode cs = new CaesarCode();

        //When
        String result = cs.decode(original);

        //Then
        Assert.assertEquals(destination, result);
    }

    @Test
    public void sanityTestEncoding(){
        //Given
        final String original = "def";
        final String destination = "abc";
        CaesarCode cs = new CaesarCode();

        //When
        String result = cs.encode(original);

        //Then
        Assert.assertEquals(destination, result);
    }

    @Test
    public void complexStringTest(){
        //Given
        final String toDecodeAndEncode = "asgeAfgrplAGnTnQWERaaabngothtlwa";
        CaesarCode cs = new CaesarCode();

        //When
        String decoded = cs.decode(toDecodeAndEncode);
        String encoded = cs.encode(decoded);

        //Then
        Assert.assertEquals(toDecodeAndEncode, encoded);
    }

    @Test
    public void numericInStringExceptionTest(){
        //Given
        final String stringWithNumericChar = "abc12";
        final String expectedMessage = "String contains numeric character which is forbidden";
        CaesarCode cs = new CaesarCode();

        //When
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            cs.decode(stringWithNumericChar);
        });
        String exceptionMessage = exception.getMessage();

        Assert.assertEquals(exceptionMessage, expectedMessage);
    }
}
