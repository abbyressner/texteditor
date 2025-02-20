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

    /**
     * Inserts a character at the current cursor position.
     *
     * @param ch the character to insert
     */
    public void insert(char ch) {
        if (gapStart == gapEnd) {
            expandBuffer();
        }
        gapStart++;
        buffer[gapStart] = ch;
    }

    /**
     * Expands the buffer size when the gap is filled.
     */
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

    /**
     * Deletes the character at the current cursor position.
     */
    public void delete() {
        if (getSize() == 0) {
            return;
        }
        gapStart--;
    }

    /**
     * Returns the current cursor position in the buffer.
     *
     * @return int cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * Moves the cursor one position to the left, if possible.
     */
    public void moveLeft() {
        if (cursor > 0) {
            cursor--;
        }
    }

    /**
     * Moves the cursor one position to the right, if possible.
     */
    public void moveRight() {
        if (cursor < sz) {
            cursor++;
        }
    }

    /**
     * Returns the size of the buffer.
     *
     * @return int sz
     */
    public int getSize() {
        return buffer.length;
    }

    /**
     * Returns the character at the specified index.
     *
     * @param i the index of the character
     * @return char the character at the index
     */
    public char getChar(int i) {
        return buffer[i];
    }

    /**
     * Returns the buffer as a string.
     *
     * @return String the buffer as a string
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < buffer.length; i++) {
            s += buffer[i];
        }
        return s;
    }
}
