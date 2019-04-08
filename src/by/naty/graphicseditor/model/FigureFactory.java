package by.naty.graphicseditor.model;

import by.naty.graphicseditor.model.figures.*;

public class FigureFactory {

    private static final int DEFAULT_SIZE = 20;
    private static FigureFactory instance = null;

    public static FigureFactory getInstance()
    {
        if (instance == null) {
            instance = new FigureFactory();
        }
        return instance;
    }

    private FigureFactory() {}


    public AbstractFigure create(FigureType figureType, double bottomRightX, double bottomRightY)
    {
        switch (figureType) {
            case Rectangle:
                return new Rectangle(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Square:
                return new Square(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Oval:
                return new Oval(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Circle:
                return new Circle(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Triangle:
                return new Triangle(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Line:
                return new Line(bottomRightX, bottomRightY, bottomRightX, bottomRightY);
            default:
                throw new IllegalArgumentException("Unsupported type: " + figureType);
        }
    }
}
