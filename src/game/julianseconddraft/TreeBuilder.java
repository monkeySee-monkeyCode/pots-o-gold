package game.julianseconddraft;
import game.Board;

import static game.julianseconddraft.Strategery.isMyMove;

/**
 * Created by Joe on 2/1/2015.
 */
public class TreeBuilder {

    public static void buildTree(Board board){
        int[] rawBoard = board.getBoardRaw();
        int potsRemaining = rawBoard.length;
        Node currentNode;

        Node root = new Node();
        root.convertToRoot();
        currentNode = root;



       while(root.totalWins < 0){
        //Am I done on this branch?
           if (currentNode.totalWins > 0){
               potsRemaining++;
               currentNode = currentNode.parent;
           }

        //Am I at the bottom?
           if (potsRemaining == 1){
               if(isMyMove(potsRemaining)){
                   if (currentNode.isLeft()){
                       if (rawBoard[currentNode.rightPointer]+currentNode.currentScore > 0){
                           currentNode.totalWins = 1;

                       }
                       else {
                           currentNode.totalWins = 0;

                       }
                   }
                   else {
                       if (rawBoard[currentNode.leftPointer]+currentNode.currentScore > 0){
                           currentNode.totalWins = 1;

                       }
                       else {
                           currentNode.totalWins = 0;

                       }
                   }

               }
               else if(!isMyMove(potsRemaining)){
                   if (currentNode.isLeft()){
                       if (rawBoard[currentNode.rightPointer]-currentNode.currentScore > 0){
                           currentNode.totalWins = 1;

                       }
                       else {
                           currentNode.totalWins = 0;

                       }
                   }
                   else {
                       if (rawBoard[currentNode.leftPointer]-currentNode.currentScore > 0){
                           currentNode.totalWins = 1;

                       }
                       else {
                           currentNode.totalWins = 0;

                       }
                   }
                   potsRemaining++;
                   currentNode = currentNode.parent;

           }
           //Do I have a left?
           if (!currentNode.hasLeft()){
               currentNode.spawnChild(rawBoard);
               currentNode = currentNode.left;
               potsRemaining--;
           }

           }

           //Do I need to score this node?
           if (currentNode.hasLeft() && currentNode.hasRight()){
               if (currentNode.left.totalWins >= 0 && currentNode.right.totalWins >= 0 && currentNode.totalWins == -1) {
                   currentNode.totalWins = currentNode.left.totalWins + currentNode.right.totalWins;
                   potsRemaining++;
                   currentNode = currentNode.parent;
               } else {
                   currentNode = currentNode.right;
                   potsRemaining--;
               }

           }

       }

       }
}
