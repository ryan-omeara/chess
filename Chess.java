import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
public class Chess extends Application {

    /*
    *
    *  JavaFX terminal compile:   javac --module-path="/Users/ryanomeara/Desktop/CS Projects/Chess/javafx-sdk-11.0.2 copy/lib" --add-modules=javafx.controls Chess.java
    *  JavaFX terminal run:   java --module-path="/Users/ryanomeara/Desktop/CS Projects/Chess/javafx-sdk-11.0.2 copy/lib" --add-modules=javafx.controls Chess   
    *
    */

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Chess");
        primaryStage.setMinHeight(650);
        primaryStage.setMinWidth(600);
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane);
        //Create and add background template grid
        GridPane template = new GridPane();
        template.setMinHeight(650);
        template.setMinWidth(600);
        pane.getChildren().add(template);
          //Create and add board image
          ImageView imageView = new ImageView(new Image("Chess_Board.png"));
          imageView.setFitHeight(600);
          imageView.setFitWidth(600);
          template.add(imageView, 0, 0);

        //Create and add main grid
        StackPane gridBase = new StackPane();
        gridBase.setMinHeight(600);
        gridBase.setMinWidth(600);
        GridPane grid = new GridPane();
        grid.setMinHeight(600);
        grid.setMinWidth(600);
        gridBase.getChildren().add(grid);
        template.add(gridBase, 0, 0);
        //Note: each square on board is 75 x 75

        //Make an end screen if the king is killed
    StackPane endScreen = new StackPane();
    endScreen.setMinSize(250, 150);
    Rectangle endRec = new Rectangle(400, 150, Color.LIGHTSKYBLUE);
    endScreen.getChildren().add(endRec);
    Text endText = new Text("error!");
    endText.setFont(new Font(75));
    endScreen.getChildren().add(endText);


        //Creates UI Bottom Panel
        GridPane bottomPanel = new GridPane();
        bottomPanel.setMinHeight(50);
        bottomPanel.setMinWidth(600);
        bottomPanel.setHgap(5);
        bottomPanel.setVgap(5);
        template.add(bottomPanel, 0, 1);
        //Display of Whose Turn it Is
        StackPane turnDisplay = new StackPane();
        turnDisplay.setMinSize(20, 50);
        bottomPanel.add(turnDisplay, 15, 0);
        Rectangle turnRec = new Rectangle(120, 30, Color.DIMGRAY);
        turnDisplay.getChildren().add(turnRec);
        Text turnText = new Text("White's Turn");
        turnText.setFont(new Font(20));
        turnText.setFill(Color.WHITE);
        turnDisplay.getChildren().add(turnText);
        //Button to Reset Game
        Button resetButton = new Button("Start New Game");
        resetButton.setMinSize(160, 40);
        bottomPanel.add(resetButton, 40, 0);



        //Create ALL the grid squares
        ChessSlot a1 = new ChessSlot(primaryStage, grid, "a1", 0, 0);
        ChessSlot b1 = new ChessSlot(primaryStage, grid, "b1", 1, 0);
        ChessSlot c1 = new ChessSlot(primaryStage, grid, "c1", 2, 0);
        ChessSlot d1 = new ChessSlot(primaryStage, grid, "d1", 3, 0);
        ChessSlot e1 = new ChessSlot(primaryStage, grid, "e1", 4, 0);
        ChessSlot f1 = new ChessSlot(primaryStage, grid, "f1", 5, 0);
        ChessSlot g1 = new ChessSlot(primaryStage, grid, "g1", 6, 0);
        ChessSlot h1 = new ChessSlot(primaryStage, grid, "h1", 7, 0);

        ChessSlot a2 = new ChessSlot(primaryStage, grid, "a2", 0, 1);
        ChessSlot b2 = new ChessSlot(primaryStage, grid, "b2", 1, 1);
        ChessSlot c2 = new ChessSlot(primaryStage, grid, "c2", 2, 1);
        ChessSlot d2 = new ChessSlot(primaryStage, grid, "d2", 3, 1);
        ChessSlot e2 = new ChessSlot(primaryStage, grid, "e2", 4, 1);
        ChessSlot f2 = new ChessSlot(primaryStage, grid, "f2", 5, 1);
        ChessSlot g2 = new ChessSlot(primaryStage, grid, "g2", 6, 1);
        ChessSlot h2 = new ChessSlot(primaryStage, grid, "h2", 7, 1);
        
        ChessSlot a3 = new ChessSlot(primaryStage, grid, "a3", 0, 2);
        ChessSlot b3 = new ChessSlot(primaryStage, grid, "b3", 1, 2);
        ChessSlot c3 = new ChessSlot(primaryStage, grid, "c3", 2, 2);
        ChessSlot d3 = new ChessSlot(primaryStage, grid, "d3", 3, 2);
        ChessSlot e3 = new ChessSlot(primaryStage, grid, "e3", 4, 2);
        ChessSlot f3 = new ChessSlot(primaryStage, grid, "f3", 5, 2);
        ChessSlot g3 = new ChessSlot(primaryStage, grid, "g3", 6, 2);
        ChessSlot h3 = new ChessSlot(primaryStage, grid, "h3", 7, 2);

        ChessSlot a4 = new ChessSlot(primaryStage, grid, "a4", 0, 3);
        ChessSlot b4 = new ChessSlot(primaryStage, grid, "b4", 1, 3);
        ChessSlot c4 = new ChessSlot(primaryStage, grid, "c4", 2, 3);
        ChessSlot d4 = new ChessSlot(primaryStage, grid, "d4", 3, 3);
        ChessSlot e4 = new ChessSlot(primaryStage, grid, "e4", 4, 3);
        ChessSlot f4 = new ChessSlot(primaryStage, grid, "f4", 5, 3);
        ChessSlot g4 = new ChessSlot(primaryStage, grid, "g4", 6, 3);
        ChessSlot h4 = new ChessSlot(primaryStage, grid, "h4", 7, 3);

        ChessSlot a5 = new ChessSlot(primaryStage, grid, "a5", 0, 4);
        ChessSlot b5 = new ChessSlot(primaryStage, grid, "b5", 1, 4);
        ChessSlot c5 = new ChessSlot(primaryStage, grid, "c5", 2, 4);
        ChessSlot d5 = new ChessSlot(primaryStage, grid, "d5", 3, 4);
        ChessSlot e5 = new ChessSlot(primaryStage, grid, "e5", 4, 4);
        ChessSlot f5 = new ChessSlot(primaryStage, grid, "f5", 5, 4);
        ChessSlot g5 = new ChessSlot(primaryStage, grid, "g5", 6, 4);
        ChessSlot h5 = new ChessSlot(primaryStage, grid, "h5", 7, 4);

        ChessSlot a6 = new ChessSlot(primaryStage, grid, "a6", 0, 5);
        ChessSlot b6 = new ChessSlot(primaryStage, grid, "b6", 1, 5);
        ChessSlot c6 = new ChessSlot(primaryStage, grid, "c6", 2, 5);
        ChessSlot d6 = new ChessSlot(primaryStage, grid, "d6", 3, 5);
        ChessSlot e6 = new ChessSlot(primaryStage, grid, "e6", 4, 5);
        ChessSlot f6 = new ChessSlot(primaryStage, grid, "f6", 5, 5);
        ChessSlot g6 = new ChessSlot(primaryStage, grid, "g6", 6, 5);
        ChessSlot h6 = new ChessSlot(primaryStage, grid, "h6", 7, 5);

        ChessSlot a7 = new ChessSlot(primaryStage, grid, "a7", 0, 6);
        ChessSlot b7 = new ChessSlot(primaryStage, grid, "b7", 1, 6);
        ChessSlot c7 = new ChessSlot(primaryStage, grid, "c7", 2, 6);
        ChessSlot d7 = new ChessSlot(primaryStage, grid, "d7", 3, 6);
        ChessSlot e7 = new ChessSlot(primaryStage, grid, "e7", 4, 6);
        ChessSlot f7 = new ChessSlot(primaryStage, grid, "f7", 5, 6);
        ChessSlot g7 = new ChessSlot(primaryStage, grid, "g7", 6, 6);
        ChessSlot h7 = new ChessSlot(primaryStage, grid, "h7", 7, 6);

        ChessSlot a8 = new ChessSlot(primaryStage, grid, "a8", 0, 7);
        ChessSlot b8 = new ChessSlot(primaryStage, grid, "b8", 1, 7);
        ChessSlot c8 = new ChessSlot(primaryStage, grid, "c8", 2, 7);
        ChessSlot d8 = new ChessSlot(primaryStage, grid, "d8", 3, 7);
        ChessSlot e8 = new ChessSlot(primaryStage, grid, "e8", 4, 7);
        ChessSlot f8 = new ChessSlot(primaryStage, grid, "f8", 5, 7);
        ChessSlot g8 = new ChessSlot(primaryStage, grid, "g8", 6, 7);
        ChessSlot h8 = new ChessSlot(primaryStage, grid, "h8", 7, 7);
    
        
        //Makes a 2D array for slots
        ChessSlot[][] gridArray = {
            {a1, b1, c1, d1, e1, f1, g1, h1},
            {a2, b2, c2, d2, e2, f2, g2, h2},
            {a3, b3, c3, d3, e3, f3, g3, h3},
            {a4, b4, c4, d4, e4, f4, g4, h4},
            {a5, b5, c5, d5, e5, f5, g5, h5},
            {a6, b6, c6, d6, e6, f6, g6, h6},
            {a7, b7, c7, d7, e7, f7, g7, h7},
            {a8, b8, c8, d8, e8, f8, g8, h8}
        };

        resetButton.setOnAction(e -> {
            turnText.setText("White's Turn");
            turnText.setFill(Color.WHITE);
            gridBase.getChildren().remove(endScreen);
            for(ChessSlot[] row : gridArray) {
                for(ChessSlot slot : row) {
                    if(slot.hasPiece()) {
                        slot.removePiece(slot.getPiece());
                    }
                    if(slot.isSelected) {
                        slot.deSelect();
                    }
                    slot.removeHighlight();
                    slot.kingReset();
                }
            }
        //Pawn Pieces
        Pawn Wpawn1 = new Pawn(true, a2, gridArray);
        a2.addPiece(Wpawn1);
        Pawn Wpawn2 = new Pawn(true, b2, gridArray);
        b2.addPiece(Wpawn2);
        Pawn Wpawn3 = new Pawn(true, c2, gridArray);
        c2.addPiece(Wpawn3);
        Pawn Wpawn4 = new Pawn(true, d2, gridArray);
        d2.addPiece(Wpawn4);
        Pawn Wpawn5 = new Pawn(true, e2, gridArray);
        e2.addPiece(Wpawn5);
        Pawn Wpawn6 = new Pawn(true, f2, gridArray);
        f2.addPiece(Wpawn6);
        Pawn Wpawn7 = new Pawn(true, g2, gridArray);
        g2.addPiece(Wpawn7);
        Pawn Wpawn8 = new Pawn(true, h2, gridArray);
        h2.addPiece(Wpawn8);

        Pawn Bpawn1 = new Pawn(false, a7, gridArray);
        a7.addPiece(Bpawn1);
        Pawn Bpawn2 = new Pawn(false, b7, gridArray);
        b7.addPiece(Bpawn2);
        Pawn Bpawn3 = new Pawn(false, c7, gridArray);
        c7.addPiece(Bpawn3);
        Pawn Bpawn4 = new Pawn(false, d7, gridArray);
        d7.addPiece(Bpawn4);
        Pawn Bpawn5 = new Pawn(false, e7, gridArray);
        e7.addPiece(Bpawn5);
        Pawn Bpawn6 = new Pawn(false, f7, gridArray);
        f7.addPiece(Bpawn6);
        Pawn Bpawn7 = new Pawn(false, g7 , gridArray);
        g7.addPiece(Bpawn7);
        Pawn Bpawn8 = new Pawn(false, h7, gridArray);
        h7.addPiece(Bpawn8);

        

        //Rook Pieces
        Rook Wrook1 = new Rook(true, a1, gridArray);
        a1.addPiece(Wrook1);
        Rook Wrook2 = new Rook(true, h1, gridArray);
        h1.addPiece(Wrook2);
        Rook Brook1 = new Rook(false, a8, gridArray);
        a8.addPiece(Brook1);
        Rook Brook2 = new Rook(false, h8, gridArray);
        h8.addPiece(Brook2);

        //King Pieces
        King Wking = new King(true, e1, gridArray);
        e1.addPiece(Wking);
        King Bking = new King(false, e8, gridArray);
        e8.addPiece(Bking);

        //Queen Pieces
        Queen Wqueen = new Queen(true, d1, gridArray);
        d1.addPiece(Wqueen);
        Queen Bqueen = new Queen(false, d8, gridArray);
        d8.addPiece(Bqueen);

        //Bishop Pieces
        Bishop Wbishop1 = new Bishop(true, c1, gridArray);
        c1.addPiece(Wbishop1);
        Bishop Wbishop2 = new Bishop(true, f1, gridArray);
        f1.addPiece(Wbishop2);
        Bishop Bbishop1 = new Bishop(false, c8, gridArray);
        c8.addPiece(Bbishop1);
        Bishop Bbishop2 = new Bishop(false, f8, gridArray);
        f8.addPiece(Bbishop2);
    
        //Knight Pieces
        Knight Wknight1 = new Knight(true, b1, gridArray);
        b1.addPiece(Wknight1);
        Knight Wknight2 = new Knight(true, g1, gridArray);
        g1.addPiece(Wknight2);
        Knight Bknight1 = new Knight(false, b8, gridArray);
        b8.addPiece(Bknight1);
        Knight Bknight2 = new Knight(false, g8, gridArray);
        g8.addPiece(Bknight2);
    });

        ChessSlot current;
        Piece selectedPiece;

        for(int i = 0; i < 8; i++) {
            for(int r = 0; r < 8; r++) {
                ChessSlot slot = gridArray[i][r];
                slot.getPane().setOnMouseClicked(e -> {
                    //Selects the slot that was clicked if it has a piece
                    if(slot.isSelected()) {
                        ChessSlot origin = slot.getHighlightSlot();
                        origin.move(slot);
                        for(ChessSlot[] b : gridArray) {
                            for(ChessSlot x : b) {
                                if(x.kingKilled()) {
                                    if(x.kingisWhite()) {
                                        endText.setText("Black Wins!");
                                    } else {
                                        endText.setText("White Wins!");
                                    }
                                    gridBase.getChildren().add(endScreen);
                        
                                }
                            }
                        }
                        for(ChessSlot[] t : gridArray) {
                            for(ChessSlot s : t) {
                                if(s.hasPiece()) {
                                s.getPiece().changeTurn();
                                }
                            }
                        }
                        if(slot.getPiece().getTurn()) {
                            turnText.setText("White's Turn");
                            turnText.setFill(Color.WHITE);
                        } else {
                            turnText.setText("Black's Turn");
                            turnText.setFill(Color.BLACK);
                        }
                    } else if(slot.hasPiece()) {
                        if(slot.getPiece().isWhite() == slot.getPiece().getTurn()) {
                        slot.getPiece().selected();
                        }
                    }
                });
            }
        }

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
