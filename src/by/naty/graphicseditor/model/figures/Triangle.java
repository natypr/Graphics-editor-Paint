package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.FigureType;
import by.naty.graphicseditor.model.backSide.IEditable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends AbstractFigure implements IEditable {

    public Triangle(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(GraphicsContext context)
    {
        context.setFill(Color.valueOf(getFillColor()));
        context.setStroke(Color.valueOf(getPenColor()));
        context.setLineWidth(5);

        double x1 = getX1(), x2 = getX2(), y1 = getY1(), y2 = getY2();

        double xs[] = new double[] {x1, (x1 + x2) / 2, x2};
        double ys[] = new double[] {y2, y1, y2};

        context.fillPolygon(xs, ys, xs.length);
        context.strokePolygon(xs, ys, xs.length);
    }

    @Override
    public FigureType getType()
    {
        return FigureType.Triangle;
    }
}
