package by.naty.graphicseditor.model.figures;

import by.naty.graphicseditor.model.AbstractFigure;
import javafx.scene.canvas.GraphicsContext;

import static java.lang.Math.min;

public class Square extends AbstractFigure
{

    public Square(double x1, double y1, double x2, double y2)
    {
        super(x1, y1, x2, y2);
    }

    public void draw(GraphicsContext context)
    {
        double w = getWidth();
        double h = getHeight();
        context.strokeRect(getX1(), getY1(), min(w, h), min(w, h));
    }
}


/**
 *  To add a shape, change:
 *      in Controller -> FigureType.Square (for selected)
 *      in FigureFactory -> case Square (for initialisation)
 *      in FigureType -> Square (for type)
 * */