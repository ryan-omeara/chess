import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class ChessSlot {
    boolean hasPiece;
    int verticalVal;
    int horizontalVal;
    boolean isSelected;
    GridPane grid;
    Piece piece;
    String name;
    StackPane space;
    Stage stage;
    ChessSlot highlightedSlot = null;
    boolean kingKilled = false;
    boolean kingisWhite;

    public ChessSlot(Stage primaryStage, GridPane gridP, String name,int horz,int vert) {
        stage = primaryStage;
        grid = gridP;
        space = new StackPane();
        space.setMinSize(75,75);
        gridP.add(space, horz, vert);
        piece = null;
        name = null;
        verticalVal = vert;
        horizontalVal = horz;
        isSelected = false;
    }
    
    public void addPiece(Object add) {
        if(add instanceof Piece) {
            Piece addPiece = (Piece)add;
            space.getChildren().add(addPiece.getImageView());
            hasPiece = true;
            piece = addPiece;
            addPiece.setSlot(this);
        }
    }

    public void removePiece(Object remove) {
        if(remove instanceof Piece) {
            Piece removePiece = (Piece)remove;
            space.getChildren().remove(removePiece.getImageView());
            hasPiece = false;
            piece = null;
        }
    }

    Rectangle highlightRec = new Rectangle(60, 60, Color.DODGERBLUE);
    public void highlight() {
        space.getChildren().add(highlightRec);
        if(hasPiece) {
            space.getChildren().remove(piece.getImageView());
            space.getChildren().add(piece.getImageView());
        }
    }
    public void removeHighlight() {
        space.getChildren().remove(highlightRec);
    }
    Rectangle selectRec = new Rectangle(60, 60, Color.ORANGERED);
    public void select(ChessSlot origin) {
        highlightedSlot = origin;
        isSelected = true;
        space.getChildren().add(selectRec);
        if(hasPiece) {
            space.getChildren().remove(piece.getImageView());
            space.getChildren().add(piece.getImageView());
        }
    }

    public void deSelect() {
        isSelected = false;
        highlightedSlot = null;
        space.getChildren().remove(selectRec);
    }

    public void move(ChessSlot newSlot) {
        if(newSlot.hasPiece()) {
            if(newSlot.getPiece() instanceof King) {
                kingKilled = true;
                if(newSlot.getPiece().isWhite()) {
                    kingisWhite = true;
                } else {
                    kingisWhite = false;
                }
            }
            newSlot.removePiece(newSlot.getPiece());
        }
        piece.move(newSlot);
        newSlot.addPiece(piece);
        removePiece(piece);
        newSlot.deSelect();
        this.removeHighlight();
    }
    
    public StackPane getPane() { 
        return space;
    }
    public int getHorz() {
        return horizontalVal;
    }
    public int getVert() {
        return verticalVal;
    }
    public boolean hasPiece() {
        return hasPiece;
    }
    public Piece getPiece() {
        return piece;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public ChessSlot getHighlightSlot() {
        return highlightedSlot;
    }
    public boolean kingKilled() {
        return kingKilled;
    }
    public boolean kingisWhite() {
        return kingisWhite;
    }
    public void kingReset() {
        kingKilled = false;
    }
}
