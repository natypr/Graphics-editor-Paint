package by.naty.graphicseditor.model.serialization;

public interface SerializationReader extends AutoCloseable {

    double readDouble();
    String readString();
    boolean readDelimiter();
    boolean hasMoreTokens();
}
