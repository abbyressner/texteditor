package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private int gapStart;

    private int gapEnd;

    private char[] buffer;

    /**
     * Constructs a new GapBuffer with an empty buffer.
     */
    public GapBuffer() {
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
        buffer[gapStart] = ch;
        gapStart++;
    }

    /**
     * Expands the buffer size when the gap is filled.
     */
    public void expandBuffer() {
        char[] newBuffer = new char[buffer.length * 2];
        System.arraycopy(buffer, 0, newBuffer, 0, gapStart);
        int afterGap = buffer.length - gapEnd;
        int newGapEnd = (buffer.length * 2) - afterGap;
        for (int i = gapEnd; i < buffer.length; i++) {
            newBuffer[newGapEnd + (i - gapEnd)] = buffer[i];
        }
        gapEnd = newGapEnd;
        buffer = newBuffer;
    }

    /**
     * Deletes the character at the current cursor position.
     */
    public void delete() {
        if (gapStart != 0) {
            gapStart--;
        }
    }

    /**
     * Returns the current cursor position in the buffer.
     *
     * @return int cursor
     */
    public int getCursorPosition() {
        return gapStart;
    }

    /**
     * Moves the cursor one position to the left, if possible.
     */
    public void moveLeft() {
        if (gapStart > 0) {
            buffer[gapEnd - 1] = buffer[gapStart - 1];
            gapStart--;
            gapEnd--;
        }
    }

    /**
     * Moves the cursor one position to the right, if possible.
     */
    public void moveRight() {
        if (gapEnd < buffer.length) {
            buffer[gapStart] = buffer[gapEnd];
            gapStart++;
            gapEnd++;
        }
    }

    /**
     * Returns the size of the buffer.
     *
     * @return int sz
     */
    public int getSize() {
        return gapStart + (buffer.length - gapEnd);
    }

    /**
     * Returns the character at the specified index.
     *
     * @param i the index of the character
     * @return the character at index `i`
     */
    public char getChar(int i) {
        if (i < gapStart) {
            return buffer[i];
        } else {
            return buffer[i + (gapEnd - gapStart)];
        }
    }

    /**
     * Returns the buffer as a string.
     *
     * @return the buffer as a string
     */
    public String toString() {
        String s = "";
        if (gapStart > 0) {
            for (int i = 0; i < gapStart; i++) {
                s += buffer[i];
            }
        }
        if (gapEnd < buffer.length) {
            for (int i = gapEnd; i < buffer.length; i++) {
                s += buffer[i];
            }
        }
        return s;
    }
}
