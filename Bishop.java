import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bishop extends Piece{
    boolean white;
    ChessSlot space;
    Image image;
    ImageView imageView;
    ChessSlot[][] array;
    boolean isSelected;
    boolean whiteTurn;

    public Bishop(boolean isWhite, ChessSlot chess, ChessSlot[][] gridArray) {
        if(isWhite) {
            image = new Image("whitebishop.png");
        } else {
            image = new Image("blackbishop.png");
        }
        imageView = new ImageView(image);
        imageView.setFitHeight(55);
        imageView.setFitWidth(32);

        space = chess;
        white = isWhite;
        array = gridArray;
        whiteTurn = true;
    }
    public void changeTurn(){
        whiteTurn = !whiteTurn;
    }
    public boolean getTurn(){
        return whiteTurn;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void update() {
        if(isSelected) {
            int horz = space.getHorz();
            int vert = space.getVert();
        space.highlight();
            //Right Up
                for(int h = 1; h < 8; h++) {
                    if((horz + h >= 0 && horz + h <= 7) && (vert - h >= 0 && vert - h <= 7)) { 
                    if(array[vert - h][horz + h].hasPiece()) {
                        if((array[vert - h][horz + h].getPiece().isWhite() == !space.getPiece().isWhite())) {
                            array[vert - h][horz + h].select(space);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        array[vert - h][horz + h].select(space);
                    }
                }
                }
            //Right Down
                for(int h = 1; h < 8; h++) {
                    if((horz + h >= 0 && horz + h <= 7) && (vert + h >= 0 && vert + h <= 7)) {
                    if(array[vert + h][horz + h].hasPiece()) {
                        if(array[vert + h][horz + h].getPiece().isWhite() == !space.getPiece().isWhite()) {
                            array[vert + h][horz + h].select(space);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        array[vert + h][horz + h].select(space);
                    }
                }
                }
            //Left Up
                for(int v = 1; v < 8; v++) {
                    if((horz - v >= 0 && horz - v <= 7) && (vert - v >= 0 && vert - v <= 7)) {
                    if(array[vert - v][horz - v].hasPiece()) {
                        if(array[vert - v][horz - v].getPiece().isWhite() == !space.getPiece().isWhite()) {
                            array[vert - v][horz - v].select(space);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        array[vert - v][horz - v].select(space);
                    }
                }
                }
            //Left Down
                for(int v = 1; v < 8; v++) {
                    if((horz - v >= 0 && horz - v <= 7) && (vert + v >= 0 && vert + v <= 7)) {
                    if(array[vert + v][horz - v].hasPiece()) {
                        if(array[vert + v][horz - v].getPiece().isWhite() == !space.getPiece().isWhite()) {
                            array[vert + v][horz - v].select(space);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        array[vert + v][horz - v].select(space);
                    }
                }
            }
                }
            }

    public void selected() {
        for(ChessSlot[] row : array) {
            for(ChessSlot slot : row) {
                slot.removeHighlight();
                slot.deSelect();
            }
        }
        isSelected = true;
        update();
        
    }

    public void deselect() {
        isSelected = false;
        update();
    }

    public void move(ChessSlot newSlot) {
        space = newSlot;
        for(ChessSlot[] row : array) {
            for(ChessSlot s : row) {
                s.removeHighlight();
                s.deSelect();
            }
        }
    }

    public boolean isWhite() {
        return white;
    }

}