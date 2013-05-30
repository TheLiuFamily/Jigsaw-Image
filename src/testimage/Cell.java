/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testimage;

import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author LG
 */
public class Cell extends JButton {
    private static final long serialVersionUID = 1001L;
    public static final int IMAGEWIDTH = 117;
    private int place;
    
    public Cell(Icon icon, int place) {
        this.setSize(IMAGEWIDTH, IMAGEWIDTH);
        this.setIcon(icon);
        this.place = place;
    }
    
    public void move(Direction dir) {
        Rectangle rec = this.getBounds();
        switch(dir) {
            case UP:
                this.setLocation(rec.x, rec.y - IMAGEWIDTH);
                break;
            case DOWN:
                this.setLocation(rec.x, rec.y + IMAGEWIDTH);
                break;
            case LEFT:
                this.setLocation(rec.x - IMAGEWIDTH, rec.y);
                break;
            case RIGHT:
                this.setLocation(rec.x + IMAGEWIDTH, rec.y);
                break;
        }
    }
    public int getX() {
        return this.getBounds().x;
    }
    public int getY() {
        return this.getBounds().y;
    }
    public int getPlace() {
        return place;
    }
}
