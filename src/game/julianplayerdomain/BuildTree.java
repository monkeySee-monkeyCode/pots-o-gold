package game.julianplayerdomain;

import game.Board;


/**
 * Created by Julian on 1/30/2015.
 */
public class BuildTree {



    public static void buildTree(Board board){
        int[] rawBoard = board.getBoardRaw();
        int potsRemaining = rawBoard.length;
        Node currentNode;
        boolean isMyMove;
        Node root = new RootNode();
        currentNode = root;



        while (potsRemaining != 0){
            if (root == currentNode){

                root.leftPointer = 0;
                root.rightPointer = potsRemaining - 1;
                root.id = 1;
                root.left = root.spawnChild();
                root.right = root.spawnChild();
                root.currentScore = 0;
                currentNode = root.left;

            }
            if (currentNode.hasLeft() && currentNode.hasRight()){
                if (currentNode.left.totalWins >= 0 && currentNode.right.totalWins >= 0 && currentNode.totalWins == -1) {
                    currentNode.totalWins = currentNode.left.totalWins + currentNode.right.totalWins;
                    potsRemaining++;
                    currentNode = currentNode.parent;
                } else {
                    currentNode = currentNode.right;
                }

            }

            else if(potsRemaining > 1 && currentNode.isLeaf()){

                if(isMyMove && currentNode.isLeft()){
                    currentNode.currentScore = rawBoard[currentNode.parent.leftPointer] + currentNode.parent.currentScore;
                    potsRemaining--;
                    currentNode.spawnChild();
                    currentNode = currentNode.left;
                }
                else if (isMyMove) {
                    currentNode.currentScore = rawBoard[currentNode.parent.rightPointer] + currentNode.parent.currentScore;
                    potsRemaining--;
                    currentNode.spawnChild();
                    currentNode = currentNode.right;

                }
                if(!isMyMove && currentNode.isLeft()){
                    currentNode.currentScore = rawBoard[currentNode.parent.leftPointer] - currentNode.parent.currentScore;
                    potsRemaining--;
                    currentNode.spawnChild();
                    currentNode = currentNode.left;
                }
                else if (!isMyMove) {
                    currentNode.currentScore = rawBoard[currentNode.parent.rightPointer] - currentNode.parent.currentScore;
                    potsRemaining--;
                    currentNode.spawnChild();
                    currentNode = currentNode.right;

                }

            }

            else if(potsRemaining == 1 && isMyMove){
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
                potsRemaining++;
                currentNode = currentNode.parent;
            }
            else if(potsRemaining == 1 && !isMyMove){
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


        }




    }
}
