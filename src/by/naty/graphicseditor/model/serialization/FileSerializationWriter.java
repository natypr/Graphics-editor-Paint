package by.naty.graphicseditor.model.serialization;

import java.io.*;

public class FileSerializationWriter implements SerializationWriter {

    private final PrintWriter writer;

    public FileSerializationWriter(File file)
    {
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeDouble(double value)
    {
        writer.print(value);
        writer.print(' ');
    }

    @Override
    public void writeString(String value)
    {
        writer.print(value);
        writer.print(' ');
    }

    @Override
    public void writeDelimiter()
    {
        writer.println(SerializationConstants.DELIMITER);
    }

    @Override
    public void close()
    {
        writer.close();
    }
}
