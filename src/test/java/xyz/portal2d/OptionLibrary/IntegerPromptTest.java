package xyz.portal2d.OptionLibrary;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class IntegerPromptTest {
    @Test
    public void IntegerPromptTest() {
        String n = "20";
        assertEquals(new BigInteger(n), IntegerPrompt.integerPrompt("", new ByteArrayInputStream(n.getBytes(StandardCharsets.UTF_8))));
    }

    @Test
    public void LongIntegerPromptTest() {
        String n = "3485938145913941438513745";
        assertEquals(new BigInteger(n), IntegerPrompt.integerPrompt("", new ByteArrayInputStream(n.getBytes(StandardCharsets.UTF_8))));
    }
}
