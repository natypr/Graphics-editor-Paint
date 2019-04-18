package by.naty.graphicseditor.model.serialization;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static by.naty.graphicseditor.model.serialization.SerializationConstants.DELIMITER;

public class FileSerializationReader implements SerializationReader {

    // scanner is a bit of an over-kill, because we only need reading fo a string till the next whitespace
    private final Scanner reader;

    public FileSerializationReader(File file)
    {
        try {
            reader = new Scanner(new BufferedInputStream(new FileInputStream(file)));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double readDouble()
    {
        String next = reader.next();
        if (DELIMITER.equals(next)) {
            throw new RuntimeException("Reading past delimiter");
        }
        return Double.valueOf(next);
    }

    @Override
    public String readString()
    {
        String next = reader.next();
        if (DELIMITER.equals(next)) {
            throw new RuntimeException("Reading past delimiter");
        }
        return next;
    }

    @Override
    public boolean readDelimiter()
    {
        String next = reader.next();
        return DELIMITER.equals(next);
    }

    @Override
    public boolean hasMoreTokens()
    {
        return reader.hasNext();
    }

    @Override
    public void close()
    {
        reader.close();
    }
}
