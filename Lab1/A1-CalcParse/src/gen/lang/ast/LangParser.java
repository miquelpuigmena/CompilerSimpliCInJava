package lang.ast;
import beaver.*;
import java.util.ArrayList;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;
import java.util.zip.DeflaterOutputStream;

// This is a parser generated by NeoBeaver.
public class LangParser extends beaver.Parser {
  
	static public class SyntaxError extends RuntimeException { public SyntaxError(String msg) {super(msg);}}
	// Disable syntax error recovery
	protected void recoverFromError(Symbol token, TokenStream in) {
		throw new SyntaxError("Cannot recover from the syntax error");
	}

  public static class Terminals {
    public static final short EOF = 0;
    public static final short MUL = 1;
    public static final short IN = 2;
    public static final short END = 3;
    public static final short ID = 4;
    public static final short NUMERAL = 5;
    public static final short LET = 6;
    public static final short ASSIGN = 7;

    public static final String[] NAMES = {
        "EOF",
        "MUL",
        "IN",
        "END",
        "ID",
        "NUMERAL",
        "LET",
        "ASSIGN",
    };
  }

  private final Action[] actions = {
    Action.RETURN, // [0] factor =  numeral (default action: return symbol 1)
    Action.RETURN, // [1] exp =  factor (default action: return symbol 1)
    Action.RETURN, // [2] numeral =  NUMERAL (default action: return symbol 1)
    Action.RETURN, // [3] id =  ID (default action: return symbol 1)
    Action.RETURN, // [4] program =  exp (default action: return symbol 1)
    new Action() { // [5] GOAL =  program EOF
      public Symbol reduce(Symbol[] _symbols, int offset) {
        final Symbol program = _symbols[offset + 1];
        final Symbol sym2 = _symbols[offset + 2];
        return program;
      }
    },
    RETURN3, // [6] exp =  exp MUL factor (default action: return symbol 3)
    RETURN7, // [7] let =  LET id ASSIGN exp IN exp END (default action: return symbol 7)
  };

      static final Action RETURN3 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 3];
        }
      };
      static final Action RETURN7 = new Action() {
        public Symbol reduce(Symbol[] _symbols, int offset) {
          return _symbols[offset + 7];
        }
      };
  static final ParsingTables PARSING_TABLES = new ParsingTables(
    "U9oDahjImp0GHQ$i13iG4mB#04fAXegIaX9wIZw0ZeQPfAEbu5zv922EjRPYEyImEsUoLzA" +
    "k5LzBUbMcFOqqrKIfPjhNGQZ6LBb$K#BhK1DPt3#gfF#sRBRzbsNKQykeLYhYX6DMUlEtzA" +
    "UwSTZJTl#TsdzOneL2yy7#0avQ$U#Md1bpCYSduIqfLbDwgbiv9KhZ$KUR$Vh$TFS7DRUgT" +
    "6l2t$s#4yfwEjn$GFVdkOttlvvta6xtyrikpSTrU4SAtqa9ft06vt09Lt0DDt0BTt0F3$08" +
    "J$0CBqkpmYqOkh37hPfw5$NpvusclcZLfVuVEHuuN7QuKNdYSDlXUS9QYZkPPZ#eu1mE");

  public LangParser() {
    super(PARSING_TABLES);
  }

  protected Symbol invokeReduceAction(int rule_num, int offset) {
    return actions[rule_num].reduce(_symbols, offset);
  }
}
