/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testimage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import resource.SwingResourceManager;

/**
 *
 * @author LG
 */
public class GamePanel extends JPanel implements MouseListener {
    private static final long serialVersionUID = 1001L;
    private Cell[] cells = new Cell[9];
    private Cell cellBlank = null;
    
    public GamePanel() {
        super();
        setLayout(null);
        init();
    }
    public void init() {
        int num = 0;
        Icon icon = null;
        Cell cell = null;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                num = i * 3 + j;
                icon = SwingResourceManager.getIcon(GamePanel.class, "/pic/"
                        + (num+1) + ".jpg");
                cell = new Cell(icon, num);
                cell.setLocation(j * Cell.IMAGEWIDTH, i * Cell.IMAGEWIDTH);
                cells[num] = cell;
            }
        }
        for(int i = 0; i < cells.length; i++) {
            this.add(cells[i]);
        }
    }
    public void random() {
        Random rand = new Random();
        int m, n, x, y;
        if(cellBlank == null) {
            cellBlank = cells[cells.length - 1];
            for(int i = 0; i < cells.length; i++) {
                if(i != cells.length -1) {
                    cells[i].addMouseListener(this);
                }
            }
        }
        for(int i = 0; i < cells.length; i++) {
            m = rand.nextInt(cells.length);
            n = rand.nextInt(cells.length);
            x = cells[m].getX();
            y = cells[m].getY();
            cells[m].setLocation(cells[n].getX(), cells[n].getY());
            cells[n].setLocation(x, y);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        Cell cell = (Cell)e.getSource();
        int x = cellBlank.getX();
        int y = cellBlank.getY();
        if((x - cell.getX()) == Cell.IMAGEWIDTH && cell.getY() == y) {
            cell.move(Direction.RIGHT);
            cellBlank.move(Direction.LEFT);
        } else if((x - cell.getX()) == -Cell.IMAGEWIDTH && cell.getY() == y) {
            cell.move(Direction.LEFT);
            cellBlank.move(Direction.RIGHT);
        } else if(cell.getX() == x && (cell.getY() - y) == Cell.IMAGEWIDTH) {
            cell.move(Direction.UP);
            cellBlank.move(Direction.DOWN);
        } else if(cell.getX() == x && (cell.getY() - y) == -Cell.IMAGEWIDTH) {
            cell.move(Direction.DOWN);
            cellBlank.move(Direction.UP);
        }
        if(isSuccess()) {
            int i = JOptionPane.showConfirmDialog(this, "成功，再来一局？", "拼图成功",
                    JOptionPane.YES_NO_OPTION);
            if(i == JOptionPane.YES_OPTION) {
                random();
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    public boolean isSuccess() {
        for(int i = 0; i < cells.length; i++) {
            int x = cells[i].getX();
            int y = cells[i].getY();
            if(i != 0) {
                if(y / Cell.IMAGEWIDTH * 3 + x / Cell.IMAGEWIDTH != cells[i]
                        .getPlace()) {
                    return false;
                }
            }
        }
        return true;
    }
}
