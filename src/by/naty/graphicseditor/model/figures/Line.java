package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.backSide.IEditable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends AbstractFigure implements IEditable {

    public Line(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    public void draw(GraphicsContext context)
    {
        context.setFill(Color.valueOf(getFillColor()));
        context.setStroke(Color.valueOf(getPenColor()));
        context.setLineWidth(5);

        context.strokeLine(getX1(), getY1(), getX2(), getY2());
    }
}