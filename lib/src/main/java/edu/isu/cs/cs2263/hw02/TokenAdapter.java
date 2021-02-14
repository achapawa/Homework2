package edu.isu.cs.cs2263.hw02;

import java.util.Stack;
import java.util.StringTokenizer;

public class TokenAdapter implements PushbackTokenizer {

    //Creating two String stacks to store two types of tokens
    private Stack<String>stack1;
    private Stack<String> stack2;
    private String St;

    //Constructor that takes String
    public TokenAdapter(String St){
        this.St=St;

        stack1=new Stack<String>();
        stack2=new Stack<String>();

        //Using StringTokenizer Class
        StringTokenizer token =new StringTokenizer(St);

        //pushing all tokens to stack2;
        while (token.hasMoreTokens()){
            stack2.push(token.nextToken());
        }

        //pushing elements to stack2 so that tokens can be retrieved in original order.
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

    }

    @Override
    public String nextToken() {
        String tk=stack1.pop();
        stack2.push(tk);
        return tk;

    }

    @Override
    public boolean hasMoreTokens() {
        if (!stack1.isEmpty())
            return true;
        else
            return false;
    }

    @Override
    public void pushback() {
        if (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }


    }
}


