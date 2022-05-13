import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Knight extends Piece{
    boolean white;
    ChessSlot space;
    Image image;
    ImageView imageView;
    ChessSlot[][] array;
    boolean isSelected;
    boolean whiteTurn;

    public Knight(boolean isWhite, ChessSlot chess, ChessSlot[][] gridArray) {
        if(isWhite) {
            image = new Image("whiteknight.png");
        } else {
            image = new Image("blackknight.png");
        }
        imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(30);

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
            for(int i = 0; i < 8; i++) {
                for(int e = 0; e < 8; e++) {
                    ChessSlot other = array[i][e];
                    if((other.getHorz() == horz + 2) && (other.getVert() == (vert + 1))) {
                        if(other.hasPiece() == false) {
                            other.select(space);
                        } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                            other.select(space);
                        }
                    }
                    else if((other.getHorz() == horz + 2) && (other.getVert() == (vert - 1))) {
                            if(other.hasPiece() == false) {
                                other.select(space);
                            } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                                other.select(space);
                            }
                    }
                    else if((other.getHorz() == horz - 2) && (other.getVert() == (vert + 1))) {
                                if(other.hasPiece() == false) {
                                    other.select(space);
                                } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                                    other.select(space);
                                }
                    }
                    else if((other.getHorz() == horz - 2) && (other.getVert() == (vert - 1))) {
                        if(other.hasPiece() == false) {
                            other.select(space);
                        } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                            other.select(space);
                        } 
                    }
                    else if((other.getHorz() == horz + 1) && (other.getVert() == (vert + 2))) {
                        if(other.hasPiece() == false) {
                            other.select(space);
                        } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                            other.select(space);
                        } 
                    }
                    else if((other.getHorz() == horz + 1) && (other.getVert() == (vert - 2))) {
                        if(other.hasPiece() == false) {
                            other.select(space);
                        } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                            other.select(space);
                        } 
                    }
                    else if((other.getHorz() == horz - 1) && (other.getVert() == (vert + 2))) {
                        if(other.hasPiece() == false) {
                            other.select(space);
                        } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                            other.select(space);
                        } 
                    }
                    else if((other.getHorz() == horz - 1) && (other.getVert() == (vert - 2))) {
                        if(other.hasPiece() == false) {
                            other.select(space);
                        } else if (other.getPiece().isWhite() == !space.getPiece().isWhite()) {
                            other.select(space);
                        } 
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
