package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import javafx.scene.canvas.GraphicsContext;

public class Line extends AbstractFigure
{

    public Line(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    public void draw(GraphicsContext context)
    {
        context.strokeLine(getX1(), getY1(), getX2(), getY2());

    }
}