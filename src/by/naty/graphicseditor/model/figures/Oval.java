package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import by.naty.graphicseditor.model.FigureType;
import by.naty.graphicseditor.model.backSide.IEditable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends AbstractFigure implements IEditable {

    public Oval(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    public void draw(GraphicsContext context)
    {
        context.setFill(Color.valueOf(getFillColor()));
        context.setStroke(Color.valueOf(getPenColor()));
        context.setLineWidth(5);

        context.fillOval(getX1(), getY1(), getWidth(), getHeight());
        context.strokeOval(getX1(), getY1(), getWidth(), getHeight());
    }

    @Override
    public FigureType getType()
    {
        return FigureType.Oval;
    }
}