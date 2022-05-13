import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn extends Piece{
    boolean white;
    ChessSlot space;
    Image image;
    ImageView imageView;
    ChessSlot[][] array;
    boolean isSelected;
    boolean firstMove;
    boolean whiteTurn;


    public Pawn(boolean isWhite, ChessSlot chess, ChessSlot[][] gridArray) {
        if(isWhite) {
            image = new Image("whitepawn.png");
        } else {
            image = new Image("blackpawn.png");
        }
        imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(28);

        array = gridArray;
        space = chess;
        white = isWhite;
        firstMove = true;
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
        if(white) {
            boolean frontSpaceOpen = false;
            for(int i = 0; i < 8; i++) {
                for(int e = 0; e < 8; e++) {
                    ChessSlot other = array[i][e];
                    if(other.getHorz() == horz && other.getVert() == (vert + 1) && !other.hasPiece()) {
                        other.select(space);
                        frontSpaceOpen = true;
                    } else if(((other.getHorz() == (horz - 1)) || (other.getHorz() == (horz + 1))) && other.getVert() == (vert + 1)) {
                        if(other.hasPiece()) {
                            if(other.getPiece().isWhite() == false) {
                                other.select(space);
                            }
                        }
                    }
                }
            } if(firstMove & frontSpaceOpen & !array[vert + 2][horz].hasPiece()) {
                    array[vert + 2][horz].select(space);
            }
        } else {
            boolean frontSpaceOpen = false;
            for(int i = 0; i < 8; i++) {
            for(int e = 0; e < 8; e++) {
                ChessSlot other = array[i][e];
                if(other.getHorz() == horz && other.getVert() == (vert - 1) && !other.hasPiece()) {
                    other.select(space);
                    frontSpaceOpen = true;
                } else if(((other.getHorz() == (horz - 1)) || (other.getHorz() == (horz + 1))) && other.getVert() == (vert - 1)) {
                    if(other.hasPiece()) {
                        if(other.getPiece().isWhite() == true) {
                            other.select(space);
                        }
                    }
                }
            }
            } if(firstMove & frontSpaceOpen & !array[vert - 2][horz].hasPiece()) {
                    array[vert - 2][horz].select(space);
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
        firstMove = false;
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
