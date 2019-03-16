package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.FigureType;

public class FigureFactory {

    private static final int DEFAULT_SIZE = 20;

    public static AbstractFigure create(FigureType figureType, double bottomRightX, double bottomRightY)
    {
        switch (figureType) {
            case Rectangle:
                return new Rectangle(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Triangle:
                return new Triangle(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            case Circle:
                return new Circle(bottomRightX - DEFAULT_SIZE, bottomRightY - DEFAULT_SIZE, bottomRightX, bottomRightY);
            default:
                throw new IllegalArgumentException("Unsupported type: " + figureType);
        }
    }
}
