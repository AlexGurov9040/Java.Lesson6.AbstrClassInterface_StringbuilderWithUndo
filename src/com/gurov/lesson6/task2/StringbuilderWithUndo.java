package com.gurov.lesson6.task2;

public class StringbuilderWithUndo {

    public static void main(String[] args) {

        StringbuilderWithUndo app = new StringbuilderWithUndo();
        app.Start();
    }

    public static void Start(){

        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder("Hello");
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.append(" World!");
        System.out.println(undoableStringBuilder);
        undoableStringBuilder.undo();
        System.out.println(undoableStringBuilder);
    }
}
