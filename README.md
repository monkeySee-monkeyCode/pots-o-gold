# julian_algorithm_bet

*Pot of Gold*
The board is comprised of n items in a row.  Each item has a value associated with it randomly, v_n.
Players take turns taking a single item, which is taken from either the leftmost or rightmost position in play on the board.
The game ends when the board is empty.
There are 2 goals which will be tracked:
- Win more than your opponent
- Win by a larger margin than your opponent

At the start of the program, 100 Boards will be generated randomly to a list.
100 Games will be played using these boards by the 2 players and results will be tabulated.
The same 100 boards will be used in play again in player-reverse order and the results will be tabulated.