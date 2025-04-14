package edu.grinnell.csc207.texteditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * The main entry point for the TextEditor application.
     *
     * @param args command-line arguments.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }

        String path = args[0];
        GapBuffer buf = new GapBuffer();
        Path filePath = Paths.get(path);

        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            String fileContents = Files.readString(filePath);
            char[] contents = fileContents.toCharArray();
            for (char ch : contents) {
                buf.insert(ch);
            }
        }

        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        Screen screen = factory.createScreen();

        screen.startScreen();
        boolean isRunning = true;
        while (isRunning) {
            drawBuffer(buf, screen);
            KeyStroke stroke = screen.readInput();
            KeyType key = stroke.getKeyType();
            if (key == KeyType.Character) {
                buf.insert(stroke.getCharacter());
            } else if (key == KeyType.Backspace) {
                buf.delete();
            } else if (key == KeyType.ArrowLeft) {
                buf.moveLeft();
            } else if (key == KeyType.ArrowRight) {
                buf.moveRight();
            } else if (key == KeyType.Escape) {
                isRunning = false;
            }
        }

        Files.writeString(filePath, buf.toString());
        screen.stopScreen();
    }

    /**
     * Renders the contents of the buffer.
     *
     * @param buf the text buffer holding the document's contents.
     * @param screen the screen to draw to.
     * @throws IOException
     */
    private static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        TerminalSize ts = screen.getTerminalSize();
        int maxCols = ts.getColumns();
        String text = buf.toString();
        int row = 0;
        int col = 0;
        screen.clear();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '\n') {
                row++;
                col = 0;
            } else {
                if (col >= maxCols) {
                    row++;
                    col = 0;
                }
                screen.setCharacter(col, row, TextCharacter.fromCharacter(ch)[0]);
                col++;
            }
        }
        int cursorPos = buf.getCursorPosition();
        int curRow = 0;
        int curCol = 0;
        for (int i = 0; i < cursorPos; i++) {
            char ch = text.charAt(i);
            if (ch == '\n') {
                curRow++;
                curCol = 0;
            } else {
                if (curCol >= maxCols) {
                    curRow++;
                    curCol = 0;
                }
                curCol++;
            }
        }
        screen.setCursorPosition(new TerminalPosition(curCol, curRow));
        screen.refresh();
    }
}