package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private int sz, cursor, gapStart, gapEnd;
    private char[] buffer;

    /**
     * Constructs a new GapBuffer with an empty buffer.
     *
     * @param sz the size of the buffer
     * @param cursor the current cursor position in the buffer
     * @param buffer the buffer character array
     */
    public GapBuffer() {
        cursor = 0;
        buffer = new char[10];
        gapStart = 0;
        gapEnd = buffer.length;
    }

    public void insert(char ch) {
        if (gapStart == gapEnd) {
            expandBuffer();
        }
        gapStart++;
        buffer[gapStart] = ch;
    }

    public void expandBuffer() {
        sz = buffer.length;
        char[] newBuffer = new char[sz * 2];
        for (int i = 0; i < gapStart; i++) {
            newBuffer[i] = buffer[i];
        }
        for (int i = gapEnd; i < sz; i++) {
            newBuffer[i + sz] = buffer[i];
        }
        sz = newBuffer.length;
        gapEnd += sz;
        buffer = newBuffer;
    }

    public void delete() {
        if (getSize() == 0) {
            return;
        }
        gapStart--;
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if (cursor > 0) {
            cursor--;
        }
    }

    public void moveRight() {
        if (cursor < sz) {
            cursor++;
        }
    }

    public int getSize() {
        return buffer.length;
    }

    public char getChar(int i) {
        return buffer[i];
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < buffer.length; i++) {
            s += buffer[i];
        }
        return s;
    }
}
