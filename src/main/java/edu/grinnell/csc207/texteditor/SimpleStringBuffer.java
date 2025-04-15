package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a String.
 */
public class SimpleStringBuffer {

    private int sz;

    private int cursor;

    private String buffer;

    /**
     * Constructs a new SimpleStringBuffer with an empty buffer.
     */
    public SimpleStringBuffer() {
        sz = 0;
        cursor = 0;
        buffer = "";
    }

    /**
     * Inserts a character at the current cursor position.
     *
     * @param ch the character to insert
     */
    public void insert(char ch) {
        buffer = buffer.substring(0, cursor) + ch + buffer.substring(cursor);
        cursor++;
        sz++;
    }

    /**
     * Deletes the character at the current cursor position.
     */
    public void delete() {
        if (cursor == 0) {
            return;
        }
        buffer = buffer.substring(0, cursor - 1) + buffer.substring(cursor);
        cursor--;
        sz--;
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
        return sz;
    }

    /**
     * Returns the character at the given index.
     *
     * @param i index of character to return
     * @return character at index `i`
     * @throws IndexOutOfBoundsException if `i` is out of bounds
     */
    public char getChar(int i) {
        if (i < 0 || i >= sz) {
            throw new IndexOutOfBoundsException();
        }
        return buffer.charAt(i);
    }

    /**
     * Returns the buffer as a string.
     *
     * @return String buffer
     */
    @Override
    public String toString() {
        return buffer;
    }
}
