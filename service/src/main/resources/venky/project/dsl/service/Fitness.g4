grammar Fitness;

@lexer::header {
package venky.project.dsl.antlr4;
}

@parser::header {
package venky.project.dsl.antlr4;
}

command :  (H O W WHITESPACE M A N Y WHITESPACE C A L O R I E S WHITESPACE I N WHITESPACE FRUIT | I WHITESPACE EXERCISE WHITESPACE NUMBER WHITESPACE DISTANCE  WHITESPACE I N WHITESPACE NUMBER WHITESPACE TIME);

/* Lexer rules */
TIME: (H O U R (S)? | M I N U T E (S)?);

DISTANCE: (M I L E (S)? | K I L O M E T E R (S)?);

//Use regex here for tenses handling
EXERCISE : (R A N | W A L K E D | S W A M | C Y C L E D);

// Not enough fruits
FRUIT : (A P P L E | O R A N G E);

// Potential to extend this to other types of food.
FOOD : F R U I T;

WS : [\t\r\n]+ -> skip;

// Lexer rules
NUMBER : [0-9];
A : ('a'|'A');
B : ('b'|'B');
C : ('c'|'C');
D : ('d'|'D');
E : ('e'|'E');
F : ('f'|'F');
G : ('g'|'G');
H : ('h'|'H');
I : ('i'|'I');
J : ('j'|'J');
K : ('k'|'K');
L : ('l'|'L');
M : ('m'|'M');
N : ('n'|'N');
O : ('o'|'O');
P : ('p'|'P');
Q : ('q'|'Q');
R : ('r'|'R');
S : ('s'|'S');
T : ('t'|'T');
U : ('u'|'U');
V : ('v'|'V');
W : ('w'|'W');
X : ('x'|'X');
Y : ('y'|'Y');
Z : ('z'|'Z');
WHITESPACE: ' ';
