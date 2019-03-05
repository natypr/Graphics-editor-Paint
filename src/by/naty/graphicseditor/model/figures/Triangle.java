package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import javafx.scene.canvas.GraphicsContext;

public class Triangle extends AbstractFigure {

    public Triangle(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(GraphicsContext context)
    {
        double x1 = getX1(), x2 = getX2(), y1 = getY1(), y2 = getY2();
        context.strokeLine(x1, y2, (x1 + x2) / 2, y1);
        context.strokeLine((x1 + x2) / 2, y1, x2, y2);
        context.strokeLine(x2, y2, x1, y2);
    }
}
