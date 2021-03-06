package ast;

import compiler.Visitor;

/*
 Espresso Compiler - https://github.com/neevsamar/espresso.git
 
 Alireza Samar (A147053)
 Sepideh Sattar (A138894)
 */

public class IfNode extends Node
{
    private ExprNode testExpr;
    private Node thenStmt;

    public IfNode(ExprNode testExpr, Node thenStmt, int lineNumber, int colNumber)
    {
        super(lineNumber, colNumber);
        this.testExpr = testExpr;
        this.thenStmt = thenStmt;
    }

    public Object accept(Visitor v)
    {
        return v.visit(this);
    }

    public Object visitTest(Visitor v)
    {
        return testExpr.accept(v);
    }

    public Object visitThen(Visitor v)
    {
        return thenStmt.accept(v);
    }

    public String toString()
    {
        return "if (" + testExpr + ")";
    }
}