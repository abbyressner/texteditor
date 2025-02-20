package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class GapBufferTests {

    @Test
    public void testEmptyBuffer() {
        GapBuffer buffer = new GapBuffer();
        assertEquals(0, buffer.getSize());
        assertEquals(0, buffer.getCursorPosition());
        assertEquals("", buffer.toString());
    }

    @Test
    public void testInsert() {
        GapBuffer buffer = new GapBuffer();
        char[] arr = "insert".toCharArray();
        for (char ch : arr) {
            buffer.insert(ch);
        }
        assertEquals("insert", buffer.toString());
        assertEquals(6, buffer.getCursorPosition());
    }

    @Test
    public void testDelete() {
        GapBuffer buffer = new GapBuffer();
        char[] arr = "delete".toCharArray();
        for (char ch : arr) {
            buffer.insert(ch);
        }
        buffer.delete();
        assertEquals("delet", buffer.toString());
        assertEquals(5, buffer.getSize());
        assertEquals(5, buffer.getCursorPosition());
    }

    @Test
    public void testMoveLeft() {
        GapBuffer buffer = new GapBuffer();
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
        buffer.insert('L');
        buffer.moveLeft();
        assertEquals(0, buffer.getCursorPosition());
    }

    @Test
    public void testMoveRight() {
        GapBuffer buffer = new GapBuffer();
        buffer.insert('R');
        buffer.moveRight();
        assertEquals(1, buffer.getCursorPosition());
    }

    @Test
    public void testGetChar() {
        GapBuffer buffer = new GapBuffer();
        char[] arr = "getchar".toCharArray();
        for (char ch : arr) {
            buffer.insert(ch);
        }
        assertEquals('g', buffer.getChar(0));
        assertEquals('e', buffer.getChar(1));
        assertEquals('t', buffer.getChar(2));
    }
    
    @Property
    public void propertyTestInsert(@ForAll String str) {
        GapBuffer buffer = new GapBuffer();
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            buffer.insert(ch);
        }
        assertEquals(str, buffer.toString());
        assertEquals(str.length(), buffer.getCursorPosition());
        assertEquals(str.length(), buffer.getSize());
    }
}