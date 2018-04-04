grammar fitness;

/* Parser rules */
nutrition_command : H O W M A N Y C A L O R I E S I N FRUIT;
exercise_command  : I WHITESPACE EXERCISE WHITESPACE NUMBER DISTANCE;

/* Lexer rules */
DISTANCE: M I L E (S+) | K I L O M E T E R (S+);

//Use regex here for tenses handling
EXERCISE : R A N | W A L K E D | S W A M | C Y C L E D;

// Not enough fruits
FRUIT : A P P L E | O R A N G E;

// Potential to extend this to other types of food.
FOOD : FRUIT;

// Lexer rules
fragment LOWERCASE : [a-z];
fragment UPPERCASE : [A-Z];
fragment DIGIT : [0-9];
fragment A : 'a'|'A';
fragment B : 'b'|'B';
fragment C : 'c'|'C';
fragment D : 'd'|'D';
fragment E : 'e'|'E';
fragment F : 'f'|'F';
fragment G : 'g'|'G';
fragment H : 'h'|'H';
fragment I : 'i'|'I';
fragment J : 'j'|'J';
fragment K : 'k'|'K';
fragment L : 'l'|'L';
fragment M : 'm'|'M';
fragment N : 'n'|'N';
fragment O : 'o'|'O';
fragment P : 'p'|'P';
fragment Q : 'q'|'Q';
fragment R : 'r'|'R';
fragment S : 's'|'S';
fragment T : 't'|'T';
fragment U : 'u'|'U';
fragment V : 'v'|'V';
fragment W : 'w'|'W';
fragment X : 'x'|'X';
fragment Y : 'y'|'Y';
fragment Z : 'z'|'Z';

WHITESPACE : (' ' | '\t');

NEWLINE : ('\r'? '\n' | '\r')+;

NUMBER : DIGIT+ ([.,] DIGIT+)? ;
