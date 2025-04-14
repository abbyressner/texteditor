package edu.grinnell.csc207.texteditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.googlecode.lanterna.TerminalPosition;
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
        screen.clear();
        String text = buf.toString();
        for (int i = 0; i < text.length(); i++) {
            screen.setCharacter(i, 0, TextCharacter.fromCharacter(text.charAt(i))[0]);
        }
        int cursorPos = buf.getCursorPosition();
        screen.setCursorPosition(new TerminalPosition(cursorPos, 0));
        screen.refresh();
    }
}
