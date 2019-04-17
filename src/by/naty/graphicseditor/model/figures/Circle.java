package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.backSide.IEditable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import static java.lang.Math.min;

public class Circle extends AbstractFigure implements IEditable {

    public Circle(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(GraphicsContext context)
    {
        context.setFill(Color.valueOf(getFillColor()));
        context.setStroke(Color.valueOf(getPenColor()));
        context.setLineWidth(5);

        double w = getWidth();
        double h = getHeight();
        context.fillOval(getX1(), getY1(), min(w, h), min(w, h));
        context.strokeOval(getX1(), getY1(), min(w, h), min(w, h));
    }
}
