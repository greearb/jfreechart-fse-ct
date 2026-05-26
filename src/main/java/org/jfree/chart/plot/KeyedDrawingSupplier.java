package org.jfree.chart.plot;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;


public interface KeyedDrawingSupplier extends DrawingSupplier {
    /**
     * Returns the next paint in a sequence maintained by the supplier,
     * contengent on a key
     *
     * @param key A series key.
     * @return The paint.
     */
    public Paint getNextPaint(Comparable<?> key);

    /**
     * Returns the next outline paint in a sequence maintained by the supplier,
     * contengent on a key.
     *
     * @param key A series key.
     * @return The paint.
     */
    public Paint getNextOutlinePaint(Comparable<?> key);

    /**
     * Returns the next fill paint in a sequence maintained by the supplier,
     * contengent on a key.
     *
     * @param key A series key.
     * @return The paint.
     *
     * @since 1.0.6
     */
    public Paint getNextFillPaint(Comparable<?> key);

    /**
     * Returns the next <code>Stroke</code> object in a sequence maintained by
     * the supplier, contengent on a key.
     *
     * @param key A series key.
     * @return The stroke.
     */
    public Stroke getNextStroke(Comparable<?> key);

    /**
     * Returns the next <code>Stroke</code> object in a sequence maintained by
     * the supplier, contengent on a key.
     *
     * @param key A series key.
     * @return The stroke.
     */
    public Stroke getNextOutlineStroke(Comparable<?> key);

    /**
     * Returns the next <code>Shape</code> object in a sequence maintained by
     * the supplier, contengent on a key.
     *
     * @param key A series key.
     * @return The shape.
     */
    public Shape getNextShape(Comparable<?> key);
}

