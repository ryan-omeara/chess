import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {
    boolean white;
    ChessSlot space;
    Image image;
    ImageView imageView;

    public abstract ImageView getImageView();
    
    public abstract void move(ChessSlot newSlot);

    public abstract void selected();

    public abstract void deselect();

    public abstract void update();

    public abstract void changeTurn();

    public abstract boolean getTurn();

    public void setSlot(ChessSlot slot) {
        space = slot;
    }
    public boolean isWhite() {
        return white;
    }
}