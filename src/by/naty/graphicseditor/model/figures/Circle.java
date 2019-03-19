package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import javafx.scene.canvas.GraphicsContext;

import static java.lang.Math.min;

public class Circle extends AbstractFigure {
    public Circle(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(GraphicsContext context)
    {
        double w = getWidth();
        double h = getHeight();
        context.strokeOval(getX1(), getY1(), min(w, h), min(w, h));
    }
}
