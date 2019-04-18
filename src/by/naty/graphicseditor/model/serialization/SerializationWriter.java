package by.naty.graphicseditor.model.serialization;

public interface SerializationWriter extends AutoCloseable {

    void writeDouble(double value);
    void writeString(String value);
    void writeDelimiter();
}
